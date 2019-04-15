package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;

import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;



/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;
	@Autowired
	private ArtistService artistService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/**
	 * Signup user
	 * @param data
	 * @return string success/failed

	 */
	@PutMapping(value = "/")
	public ResponseEntity<String> signup(@RequestBody UserDto data) {

		boolean addUser = userService.addNewUser(data.getUsername(), data.getPassword(), data.getMail(), data.getCity());

		if(addUser) return new ResponseEntity("success",HttpStatus.OK);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

	}

	/**
	 * Signup artist
	 * @param artist
	 * @return string success/failed
	 */
	@PutMapping("/artist/")
	public ResponseEntity<String> signup(@RequestBody ArtistDto artist, @RequestBody UserDto data){

		boolean addArtist = userService.addNewUser(data.getUsername(), data.getPassword(),
				data.getMail(), data.getCity(), artist);

        if (addArtist) return new ResponseEntity("success",HttpStatus.OK);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

    }


	/**
	 * user exist
	 * @param username
	 * @return boolean
	 */
	@GetMapping("/exists")
	public ResponseEntity<Boolean> userExist(@RequestParam String username){

		if(userService.userExist(username))
			return new ResponseEntity<>(true, HttpStatus.OK);

		return new ResponseEntity<>(false, HttpStatus.OK);
	}

	/**
	 * artist exist
	 * @param nameArtist
	 * @return boolean
	 */
	@GetMapping("/artist/exists")
	public ResponseEntity<Boolean> artistExist(@RequestParam String nameArtist){

		if(artistService.existsByNameArtist(nameArtist))
			return new ResponseEntity<>(true, HttpStatus.OK);

		return new ResponseEntity<>(false, HttpStatus.OK);
	}

	@PutMapping("/updateMyPassword/")
	public Response updatePassword(@RequestBody String oldPassword , @RequestBody String newPassword, @RequestBody String mail) {
		User user = getAuthenticatedUser();
		if (userService.getUserByUsername(user) != null){
			userService.updatePassword(user.getEmail(), newPassword);
			return  Response.status(200).entity(new Message("Your password has been reset successfully", null)).build();
		}
		return  Response.status(200).entity(new Message("*Request not authorized", null)).build();
	}



	}



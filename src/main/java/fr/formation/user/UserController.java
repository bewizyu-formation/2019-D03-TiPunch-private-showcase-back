package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.UserDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;



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

		boolean addUser = userService.addNewUserAndArtist(data, SecurityConstants.ROLE_USER);

		if(addUser) return new ResponseEntity("success",HttpStatus.OK);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

	}

	/**
	 * Signup artist
	 * @param data the user dto
	 * @return string success/failed
	 */
	@PutMapping("/artist/")
	public ResponseEntity<String> signupArtist(@RequestBody UserDto data){

		boolean addArtist = userService.addNewUserAndArtist(data, SecurityConstants.ROLE_USER);


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

    /**
     * All artists
     * @return list artists
     */
    @GetMapping("/artist/list")
    @Secured(SecurityConstants.ROLE_USER)
    public ResponseEntity<List<Artist>> allArtist(){

        List<Artist> artists = this.artistService.getArtists(getAuthenticatedUser());

        if (artists.isEmpty()) return new ResponseEntity<>(artists,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(artists,HttpStatus.OK);
    }


	@GetMapping("/getUser")
	@Secured(SecurityConstants.ROLE_USER)
	public User getUser(){
		User user = userService.getUser(getAuthenticatedUser());
		return user;
	}


	}


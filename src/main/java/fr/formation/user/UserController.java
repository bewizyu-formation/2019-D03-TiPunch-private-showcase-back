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
	public ResponseEntity<String> signup(@RequestBody ArtistDto artist){

		boolean addArtist = artistService.addNewArtist(artist.getUsername(), artist.getPasswordArtist(),
				artist.getMailArtist(), artist.getCityArtist(), artist.getNameArtist(),artist.getDescriptionArtist());

		boolean addUser = false;

		if(addArtist){
			addUser = userService.addNewUser(artist.getUsername(), artist.getPasswordArtist(),
					artist.getMailArtist(), artist.getCityArtist() );
		}

        if (addArtist && addUser) return new ResponseEntity("success",HttpStatus.OK);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

    }

	/**
	 * user exist
	 * @param username
	 * @return boolean
	 */
	@GetMapping("/exists")
	public ResponseEntity<User> userExist(@RequestParam String username){

		if(userService.userExist(username))
			return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);

		return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.BAD_REQUEST);
	}

	/**
	 * artist exist
	 * @param nameArtist
	 * @return boolean
	 */
	@GetMapping("/artist/exists")
	public ResponseEntity<Artist> artistExist(@RequestParam String nameArtist){

		if(artistService.existsByNameArtist(nameArtist))
			return new ResponseEntity<>(artistService.findArtistByNameArtist(nameArtist), HttpStatus.OK);

		return new ResponseEntity<>(artistService.findArtistByNameArtist(nameArtist), HttpStatus.BAD_REQUEST);
	}


	/**
	 * All artists
	 * @return list artists
	 */
	@GetMapping("/artist/list")
	@Secured({SecurityConstants.ROLE_USER})
	public ResponseEntity<List<Artist>> allArtist(){

		List<Artist> artists = this.artistService.getArtists(getAuthenticatedUser());

		if (artists.isEmpty()) return new ResponseEntity<>(artists,HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(artists,HttpStatus.OK);
	}

}

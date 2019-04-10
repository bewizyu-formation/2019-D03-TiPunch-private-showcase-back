package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
import fr.formation.models.Artist;
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
	 *
	 *
	 */
	@PutMapping(value = "/")
	public ResponseEntity<String> signup(@RequestBody UserDto data) {

		boolean addUser = userService.addNewUser(data.getUsername(), data.getPassword(), data.getMail(), data.getCity());

		if(addUser) return new ResponseEntity("success",HttpStatus.CREATED);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/artist/")
	public ResponseEntity<String> signup (@RequestBody ArtistDto artist){

		boolean addArtist = artistService.addNewArtist(artist.getUsername(), artist.getPasswordArtist(),
				artist.getMailArtist(), artist.getCityArtist(), artist.getNameArtist(),artist.getDescriptionArtist());

        boolean addUser = userService.addNewUser(artist.getUsername(), artist.getPasswordArtist(), artist.getMailArtist(), artist.getCityArtist() );

        if (addArtist && addUser) return new ResponseEntity("success",HttpStatus.CREATED);

		return new ResponseEntity("failed",HttpStatus.BAD_REQUEST);

    }

	@GetMapping("/exists")
	@Secured(SecurityConstants.ROLE_USER)
	public ResponseEntity<Boolean> userExist(@RequestParam String username){

		getAuthenticatedUser().getUsername();

		if(userService.userExist(username) || artistService.userExist(username)){

			return new ResponseEntity<>(true, HttpStatus.OK);
		}

		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/artist/list")
	@Secured(SecurityConstants.ROLE_USER)
	public ResponseEntity<List<Artist>> allArtist(){

		getAuthenticatedUser().getUsername();
		List<Artist> artists = this.artistService.getArtists();
		int i = artists.size();
		if (i == 0) return new ResponseEntity<>(artists,HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(artists,HttpStatus.OK);
	}


}

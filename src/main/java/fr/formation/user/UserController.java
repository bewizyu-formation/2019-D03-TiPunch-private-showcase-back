package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
import fr.formation.security.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


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
	 * Signup.
	 *
	 */
	@PutMapping(value = "/")
	public ResponseEntity signup(@RequestBody UserDto data) {

		boolean addUser = userService.addNewUser(data.getUsername(), data.getPassword(), data.getMail(), data.getCity());

		if(addUser) return new ResponseEntity(HttpStatus.CREATED);

		return new ResponseEntity(HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/artist/")
	public ResponseEntity signup (@RequestBody ArtistDto artist){
		boolean addArtist = artistService.addNewArtist(artist.getUsername(), artist.getPasswordArtist(),
				artist.getMailArtist(), artist.getCityArtist(), artist.getNameArtist(),artist.getDescriptionArtist());

        boolean addUser = userService.addNewUser(artist.getUsername(), artist.getPasswordArtist(), artist.getMailArtist(), artist.getCityArtist() );

        if (addArtist && addUser) return new ResponseEntity(HttpStatus.CREATED);

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}

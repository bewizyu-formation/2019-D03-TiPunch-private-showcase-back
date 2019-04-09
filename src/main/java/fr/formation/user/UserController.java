package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
import fr.formation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
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

	/**
	 * Signup.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping(value = "/")
	public void signup(@RequestBody UserDto data) {


		userService.addNewUser(data.getUsername(), data.getPassword(), data.getMail(), data.getCity() );

	}

	@PutMapping("/artist/")
	public void signup (@RequestBody ArtistDto artist){

	    artistService.addNewArtist(artist.getUsername(), artist.getPasswordArtist(), artist.getMailArtist(), artist.getCityArtist(), artist.getNameArtist(),artist.getDescriptionArtist());
        userService.addNewUser(artist.getUsername(), artist.getPasswordArtist(), artist.getMailArtist(), artist.getCityArtist() );

    }

}

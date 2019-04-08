package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
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
	public void signup(@RequestParam String username, @RequestParam String password,
									   @RequestParam String mail, @RequestParam String city,
									   @RequestParam String... roles) {

		userService.addNewUser(username, password, mail, city ,  roles);


	}

	@PutMapping("/artist/")
	public void signup (@RequestParam String username, @RequestParam String password,@RequestParam String mail,
						@RequestParam String city, @RequestParam String artistname, @RequestParam String description,
						@RequestParam String...roles){

		artistService.addNewArtist(username, password, mail, city, artistname, description, roles);

	}

}

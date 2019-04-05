package fr.formation.user;

import fr.formation.controller.AbstractController;
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


	/**
	 * Signup.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/")
	public void signup(@RequestParam String username, @RequestParam String password,
					   @RequestParam String mail, @RequestParam String city,
					   @RequestParam String... roles) {


		userService.addNewUser(username, password, mail, city ,  roles);

	}

}

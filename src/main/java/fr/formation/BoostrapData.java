package fr.formation;

import fr.formation.artist.ArtistService;
import fr.formation.security.SecurityConstants;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * This class configure the dataset at application start
 */
@Component
public class BoostrapData {

	private UserService userService;
	private ArtistService artistService;

	private PasswordEncoder passwordEncoder;

	/**
	 * Instantiates a new Boostrap data.
	 *
	 * @param userService     the user service
	 * @param passwordEncoder the password encoder
	 */
	@Autowired
	public BoostrapData(UserService userService, PasswordEncoder passwordEncoder, ArtistService artistService) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.artistService = artistService;
	}

	/**
	 * On start.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		userService.addNewUser(
				"admin",
				"adminAdmin1",
				"mail@test",
				"Lyon",
				SecurityConstants.ROLE_ADMIN


		);
		userService.addNewUser(
				"user",
				"userUser2",
				"mailuser@test",
				"Lyon",
				SecurityConstants.ROLE_USER
		);
		artistService.addNewArtist(
				"userArtist",
				"password",
				"mailArtiste@test",
				"Marseille",
				"Les PatateRats",
				"Ska-Punk",
				SecurityConstants.ROLE_ARTIST
		);

	}

}

package fr.formation;

import fr.formation.artist.ArtistService;
import fr.formation.modelDto.ArtistDto;
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

		userService.addNewUserAndArtist(
				"admin",
				"adminAdmin1",
				"mail@test",
				"Lyon",
				null,
				SecurityConstants.ROLE_ADMIN


		);
		userService.addNewUserAndArtist(
				"user",
				"userUser2",
				"mailuser@test",
				"Lyon",
				null,
				SecurityConstants.ROLE_USER
		);
		userService.addNewUserAndArtist(
				"userArtist",
				"artistArtist1",
				"mailArtiste@test",
				"Marseille",
				new ArtistDto("Les PatateRats","Ska-Punk"),
				SecurityConstants.ROLE_ARTIST

		);
		userService.addNewUserAndArtist(
				"userArtist2",
				"artistArtist2",
				"mailArtiste@test",
				"Lyon",
				new ArtistDto("Les PatateRats2", "Ska-Punk2"),
				SecurityConstants.ROLE_ARTIST

		);
		userService.addNewUserAndArtist(
				"userArtist3",
				"artistArtist3",
				"mailArtiste@test",
				"Lyon",
				new ArtistDto("Les PatateRats3", "Ska-Punk3"),
				SecurityConstants.ROLE_ARTIST

		);

	}

}

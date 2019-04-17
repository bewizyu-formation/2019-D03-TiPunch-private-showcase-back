package fr.formation;

import fr.formation.artist.ArtistService;
import fr.formation.image.ImageStorageService;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
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
	private ImageStorageService storageService;

	/**
	 * Instantiates a new Boostrap data.
	 *
	 * @param userService     the user service
	 * @param passwordEncoder the password encoder
	 */
	@Autowired
	public BoostrapData(UserService userService, PasswordEncoder passwordEncoder, ArtistService artistService, ImageStorageService storageService) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.artistService = artistService;
		this.storageService = storageService;
	}

	/**
	 * On start.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		userService.addNewUserAndArtist(
				new UserDto("admin", "adminAdmin1", "mail@test", "Lyon", null),
				SecurityConstants.ROLE_ADMIN

		);
		userService.addNewUserAndArtist(
				new UserDto("user", "userUser2", "mailuser@test", "Lyon", null),
				SecurityConstants.ROLE_USER
		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist", "artistArtist1", "steelpanther@st.com", "Marseille",
						new ArtistDto("Steel Panther",
								"Steel Panther est un groupe de comedy rock et glam metal américain, originaire d'Hollywood, Los Angeles, en Californie. Ils sont mieux connus pour leurs paroles humoristiques et polémiques.")
				),

				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist2", "artistArtist2", "refused@r.com", "Lyon",
						new ArtistDto("Refused",
								"Refused est un groupe de punk hardcore suédois, originaire d'Umeå. Du temps de son activité, Refused tenait une place éminente sur la prolifique scène du hardcore scandinave, connus pour leur ligne de conduite socialiste révolutionnaire straight edge et militante, et leur combat en faveur des droits des animaux.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist3", "artistArtist3", "gojira@g.com", "Lyon",
						new ArtistDto("Gojira",
								"Gojira est un groupe de metal extrême français, originaire d'Ondres. Il est initialement formé en 1996 sous le nom de Godzilla, puis adopte le nom de Gojira en 2001, lequel n'est autre que sa transcription en rōmaji.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist4", "artistArtist4", "fumanchu@fm.com", "Lyon",
						new ArtistDto("Fu Manchu",
								"Fu Manchu est un groupe de stoner rock/punk originaire du Sud de la Californie dont le premier single Kept Between Trees est sorti en 1990. Fu Manchu a été formé en 1987 comme groupe de punk hardcore sous le nom de Virulence.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist5", "artistArtist5", "sisters@tsm.com", "Paris",
						new ArtistDto("The Sisters of Mercy",
								"The Sisters of Mercy [ðə ˈsɪstəz ə ˈmɜːsɪ] est un groupe de rock gothique britannique, originaire de Leeds, en Angleterre. Il est formé en 1980 par Andrew Eldritch et Gary Marx.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist6", "artistArtist6", "kaaris@k.com", "Paris",
						new ArtistDto("Kaaris",
								"Kaaris, stylisé KΛΛRIS, de son vrai nom Okou Armand Gnakouri, né le 30 janvier 1980 à Cocody, Abidjan, est un rappeur, compositeur, acteur, producteur et entrepreneur français d'origine ivoirienne. En 2013, il publie Or noir produit par Therapy Music.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist7", "artistArtist7", "booba@b.com", "Paris",
						new ArtistDto("Booba",
								"Booba, de son vrai nom Élie Yaffa, né le 9 décembre 1976 à Boulogne-Billancourt dans les Hauts-de-Seine, est un rappeur français.")
				),
				SecurityConstants.ROLE_USER

		);
		userService.addNewUserAndArtist(
				new UserDto("userArtist8", "artistArtist8", "georges@gb.com", "Paris",
						new ArtistDto("Georges Brassens",
								"Georges Brassens, né à Sète le 22 octobre 1921 et mort à Saint-Gély-du-Fesc le 29 octobre 1981, est un poète auteur-compositeur-interprète français.")
				),
				SecurityConstants.ROLE_USER

		);

	}

}

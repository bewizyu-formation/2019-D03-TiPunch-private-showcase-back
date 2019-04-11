package fr.formation.user;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.modelDto.ArtistDto;
import fr.formation.modelDto.UserDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


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

	@GetMapping("/home")
	@Secured(SecurityConstants.ROLE_USER)
	public Set<Artist> getArtistByCityUser(){
	    String cityUser = getAuthenticatedUser().getCity();
	   Set<Artist> listArtistbyUserCity = artistService.findArtistByCity(cityUser);
	   return listArtistbyUserCity;

	}

	}




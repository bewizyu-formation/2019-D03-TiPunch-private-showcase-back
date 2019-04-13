package fr.formation.artist;


import fr.formation.controller.AbstractController;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/artists")
@Secured(SecurityConstants.ROLE_ARTIST)
public class ArtistController extends AbstractController {


    private ArtistService artistService;
    private UserService userService;

    @Autowired
    public ArtistController(ArtistService artistService, UserService userService) {
        this.artistService = artistService;
        this.userService = userService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Set<Artist>> update(@RequestBody Artist artist, @PathVariable Long id){

        // 1- Récupération du user authentifié
        User authentificatedUser = userService.getUser(getAuthenticatedUser());




        // 2- Update de l'artiste
        Set<Artist> listUpdatedArtists = artistService.update(authentificatedUser, id, artist);
        if (listUpdatedArtists.isEmpty()){
            return new ResponseEntity<>(listUpdatedArtists, HttpStatus.NOT_FOUND);
        }
        // 3- Retourne l'artiste modifié

        return new ResponseEntity<>(listUpdatedArtists, HttpStatus.OK) ;
    }





}


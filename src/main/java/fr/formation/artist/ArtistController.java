package fr.formation.artist;


import fr.formation.controller.AbstractController;
import fr.formation.modelDto.UpdateArtistDto;
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
@Secured(SecurityConstants.ROLE_USER)
public class ArtistController extends AbstractController {


    private ArtistService artistService;
    private UserService userService;

    @Autowired
    public ArtistController(ArtistService artistService, UserService userService) {
        this.artistService = artistService;
        this.userService = userService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> update(@RequestBody Artist artist, @PathVariable Long id){

        // 1- Récupération du user authentifié
        User authentificatedUser = userService.getUser(getAuthenticatedUser());

        // 2- Update de l'artiste
        Artist updatedArtists = artistService.update(authentificatedUser, id, artist);
        if (updatedArtists == null){
            return new ResponseEntity<>(updatedArtists, HttpStatus.NOT_FOUND);
        }
        // 3- Retourne l'artiste modifié

        return new ResponseEntity<>(updatedArtists, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateArtistDto> checkupdate(@PathVariable Long id){
        System.out.println("bonne fonction");
        boolean match=false;
        User authentifiedUser = userService.getUser(getAuthenticatedUser());
        Long idUser = authentifiedUser.getId();
       Set<Artist> foundArtistLinkToUser = artistService.findArtistByuserList(idUser);
        for (Artist artist : foundArtistLinkToUser){
            Long idArtist = artist.getId();
            if (id == idArtist) {
                match = true;
            }
        }
        Artist artist = artistService.getArtistById(id);

        if(artist != null){
            UpdateArtistDto updateArtistDto = new UpdateArtistDto(artist.getId(), artist.getNameArtist(), artist.getDepartments(), artist.getDescriptionArtist(), artist.getNbVote(), artist.getNoteArtist(), artist.getUrlImage(), artist.getShortDescriptionArtist(), artist.getContactPhone(), artist.getContactMail(), artist.getUrlSiteArtist(), match);

            return  new ResponseEntity<>(updateArtistDto, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





}


package fr.formation.artist;


import fr.formation.controller.AbstractController;
import fr.formation.exception.UserNotFoundException;
import fr.formation.user.UserService;
import fr.formation.image.ImageStorageService;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping("/artists")
@Secured(SecurityConstants.ROLE_USER)
public class ArtistController extends AbstractController {


    private ArtistService artistService;
    private UserService userService;
    private ImageStorageService storageService;


    @Autowired
    public ArtistController(ArtistService artistService, UserService userService, ImageStorageService storageService) {
        this.artistService = artistService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @PostMapping("{id}/upload")
    public ResponseEntity handleFileUpload(@PathVariable Long id, @RequestParam MultipartFile file, @RequestParam String pictureName ) throws IOException {

        Artist artist = artistService.getArtistById(id);

        try {
            byte[] image = storageService.store(pictureName ,file, artist);

            return new ResponseEntity<>(artist,HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(artist,HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<Artist> checkupdate(@PathVariable Long id){
      Artist artist =artistService.getArtistById(id);
      if (artist != null){

          return new ResponseEntity<>(artist,  HttpStatus.OK);
      }

      return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}


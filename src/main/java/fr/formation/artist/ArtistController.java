package fr.formation.artist;


import fr.formation.controller.AbstractController;
import fr.formation.user.UserService;
import fr.formation.image.ImageStorageService;
import fr.formation.modelDto.ArtistDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.security.SecurityConstants;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
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
    @PostMapping("{id}/upload")
    public ResponseEntity handleFileUpload(@PathVariable Long id, @RequestBody MultipartFile file, @RequestBody String pictureName ) throws IOException {

        Artist artist = artistRepository.findArtistById(id);

        try {
            byte[] image = storageService.store(pictureName ,file);
            artist.setImage(image);
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


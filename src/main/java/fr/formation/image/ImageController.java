package fr.formation.image;

import fr.formation.artist.ArtistService;
import fr.formation.controller.AbstractController;
import fr.formation.models.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/images")
public class ImageController extends AbstractController {

    private ArtistService artistService;
    private ImageStorageService storageService;

    public ImageController(ArtistService artistService, ImageStorageService storageService) {
        this.artistService = artistService;
        this.storageService = storageService;
    }

   @GetMapping("/{id}")
    public ResponseEntity getPicture(@PathVariable Long id){
        Artist artist = artistService.getArtistById(id);
        byte[] picture = storageService.loadImage(artist);

        if(artist == null){
            return new ResponseEntity<>(artist, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }

}

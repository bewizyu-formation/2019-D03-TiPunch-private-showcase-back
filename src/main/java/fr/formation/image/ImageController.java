package fr.formation.image;

import fr.formation.artist.ArtistRepository;
import fr.formation.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/images")
public class ImageController extends AbstractMethodError{

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/{id}")
    public ResponseEntity getPicture(@PathVariable Long id){

        Artist artist = artistRepository.findArtistById(id);
        if(artist != null){
            artist.getImage();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(artist);
    }


}

package fr.formation.artist;


import fr.formation.controller.AbstractController;
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

import org.springframework.core.io.Resource;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artists")
public class ArtistController extends AbstractController {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ImageStorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity handleFileUpload(@RequestBody MultipartFile file) throws IOException {
        Long id = getAuthenticatedUser().getId();
        Artist artist = artistRepository.findArtistById(id);
        try {

            byte[] image = storageService.store(file);
            artist.setImage(image);
            return new ResponseEntity<>(artist,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(artist,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/picture")
    public ResponseEntity getPicture(@PathVariable Long id){
        Long userId = getAuthenticatedUser().getId();
        Artist artist = artistRepository.findArtistById(userId);
        String test = DatatypeConverter.printBase64Binary(artist.getImage());

        return ResponseEntity.ok()
                .contentType(MediaType.ALL)
                .body(test);
    }



}


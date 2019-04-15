package fr.formation.artist;


import fr.formation.controller.AbstractController;
import fr.formation.image.ImageStorageService;
import fr.formation.models.Artist;
import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artists")
public class ArtistController extends AbstractController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private ImageStorageService storageService;


    List<String> files = new ArrayList<>();

    /**
     * All artists
     * @return list artists
     */
    @GetMapping("/artistList")
    @Secured(SecurityConstants.ROLE_USER)
    public ResponseEntity<List<Artist>> allArtist(){

        List<Artist> artists = this.artistService.getArtists(getAuthenticatedUser());

        if (artists.isEmpty()) return new ResponseEntity<>(artists,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(artists,HttpStatus.OK);
    }


    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        String message = "";
        try {
            storageService.store(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/allImages")
    public ResponseEntity<List<String>> getListImages() {
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(ArtistController.class, "getImage", fileName).build().toString())
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(fileNames);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = storageService.loadImage(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }


}


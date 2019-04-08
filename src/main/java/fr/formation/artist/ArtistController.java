package fr.formation.artist;


import fr.formation.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController extends AbstractController {

    @Autowired
    private ArtistService artistService;

    @PutMapping("/")
    public void signup (@RequestParam String username, @RequestParam String password,@RequestParam String mail,
                        @RequestParam String city, @RequestParam String artistname, @RequestParam String description,
                        @RequestParam String...roles){
        ArtistController context = new ArtistController();
        context.getAuthenticatedUsername();

    }
}


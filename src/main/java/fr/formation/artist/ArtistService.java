package fr.formation.artist;

import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.user.UserRole;
import fr.formation.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Artist service
 */
@Service
public class ArtistService {

    private ArtistRepository artistRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;



    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     *
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, UserRoleRepository userRoleRepository,
                         PasswordEncoder passwordEncoder) {
        this.artistRepository = artistRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public boolean addNewArtist(String username, String password, String mail,
                             String city, String artistName,
                             String description, String... roles) {
        Artist artist = new Artist();
        artist.setUsername(username);
        artist.setPasswordArtist(password);
        artist.setMailArtist(mail);
        artist.setCityArtist(city);
        artist.setNameArtist(artistName);
        artist.setDescriptionArtist(description);

        if(!artistRepository.existsByNameArtist(artist.getNameArtist())){
            artist.setPasswordArtist(passwordEncoder.encode(artist.getPasswordArtist()));
            artist = artistRepository.save(artist);

            for (String role : roles){
                UserRole artistRole = new UserRole();
                artistRole.setRole(role);
                artistRole.setUserId(artist.getId());

                userRoleRepository.save(artistRole);

            }
            return true;

        }

        return false;
    }


    public List<Artist> getArtists(User user){
        List<Artist> artists = artistRepository.findAll();
        // TODO
        /*
            search artist by departement user
         */
        return  artists;
    }

    public Artist findArtistByNameArtist(String nameArtist){
        Artist artist = artistRepository.findArtistByNameArtist(nameArtist);
        return  artist;
    }

    public boolean isValidPassword(String password){

        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$");
    }

    public void deleteArtistById(Long id){
        // TODO
    }
    public boolean artistExist(String username){
        if (artistRepository.existsByUsername(username)){
            return true;
        }
        return false;
    }

    public boolean existsByNameArtist(String nameArtist){
        if(artistRepository.existsByNameArtist(nameArtist)){
            return true;
        }
        return false;
    }

    public Artist finArtistById(Long id){

        Artist artist = artistRepository.findArtistsById(id);
        return artist;
    }

}

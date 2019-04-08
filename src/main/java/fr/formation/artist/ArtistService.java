package fr.formation.artist;

import fr.formation.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Artist service
 */
@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    private ArtistRoleRepository artistRoleRepository;

    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     * @param artistRoleRepository the artist role repository
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, ArtistRoleRepository artistRoleRepository) {
        this.artistRepository = artistRepository;
        this.artistRepository = artistRepository;
    }

    public void addNewArtist(String username, String password, String mail,
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
            artist = artistRepository.save(artist);
        }
        for (String role : roles){
            ArtistRole artistRole = new ArtistRole();
            artistRole.setRole(role);
            artistRole.setArtistId(artist.getId());

            artistRoleRepository.save(artistRole);
            
        }
    }

}

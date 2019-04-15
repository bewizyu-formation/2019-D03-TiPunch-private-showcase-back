package fr.formation.artist;

import fr.formation.geo.model.Commune;
import fr.formation.geo.model.DepartementAccepted;
import fr.formation.geo.services.CommuneService;
import fr.formation.geo.services.DepartementService;
import fr.formation.image.ImageStorageService;
import fr.formation.modelDto.ArtistDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import fr.formation.user.UserRole;
import fr.formation.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Artist service
 */
@Service
public class ArtistService {

    private ArtistRepository artistRepository;
    private UserRoleRepository userRoleRepository;
    private CommuneService communeService;
    private DepartementService departementService;
    private Artist artist;
    private Commune commune;
    private DepartementAccepted departementAccepted;
    private PasswordEncoder passwordEncoder;
    private ImageStorageService storageService;


    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     *
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, UserRoleRepository userRoleRepository,
                         PasswordEncoder passwordEncoder, CommuneService communeService, DepartementService departementService,
                         ImageStorageService storageService) {
        this.artistRepository = artistRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.communeService = communeService;
        this.departementService =departementService;
        this.storageService = storageService;

    }

    public List<Artist> getArtists(User user){
        List<Artist> artists = artistRepository.findAll();
        return  artists;
    }

    public Artist findArtistByNameArtist(String nameArtist){
        Artist artist = artistRepository.findArtistByNameArtist(nameArtist);
        return  artist;
    }
    public Artist findArtistById(Long id){
        Artist artist = artistRepository.findArtistById(id);

        return  artist;
    }

    public void deleteArtistById(Long id){
        artistRepository.deleteArtistById(id);
    }

    public Artist findArtistByDepartments(DepartementAccepted codeDepartementArtist){
        Artist artist = artistRepository.findArtistByDepartments(codeDepartementArtist);
        return artist;
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

package fr.formation.artist;

import fr.formation.geo.model.Commune;
import fr.formation.geo.model.DepartementAccepted;
import fr.formation.geo.services.CommuneService;
import fr.formation.geo.services.DepartementAcceptedRepository;
import fr.formation.geo.services.DepartementService;
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
    private DepartementAcceptedRepository departementAcceptedRepository;
    private CommuneService communeService;
    private DepartementService departementService;
    private PasswordEncoder passwordEncoder;

    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     *
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, UserRoleRepository userRoleRepository,
                         PasswordEncoder passwordEncoder, CommuneService communeService, DepartementService departementService,
                         DepartementAcceptedRepository departementAcceptedRepository) {
        this.artistRepository = artistRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.communeService = communeService;
        this.departementService = departementService;
        this.departementAcceptedRepository = departementAcceptedRepository;



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
    public Artist getArtistById(Long id){
        Artist artist = artistRepository.findArtistById(id);
        // TODO: Est-ce que l'artiste est trouvé ???
        if (artist != null) {
            return artist;
        }
        return  null;
    }


    public boolean isValidPassword(String password){

        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$");
    }

    public void deleteArtistById(Long id){
        artistRepository.deleteArtistById(id);
    }
    public Artist findArtistByDepartments(DepartementAccepted codeDepartementArtist){
        Artist artist = artistRepository.findArtistByDepartments(codeDepartementArtist);
        return artist;
    }
/*    public boolean artistExist(String username){
        if (artistRepository.existsByUsername(username)){
            return true;
        }
        return false;
    }*/

    public boolean existsByNameArtist(String nameArtist){
        if(artistRepository.existsByNameArtist(nameArtist)){
            return true;
        }
        return false;
    }
    public Set<Artist> findArtistByuserList(Long userId){

      Set<Artist> findArtist =  artistRepository.findByUserList_id(userId);
        return findArtist;
    }


    public Artist update(User authenticatedUser, Long idArtist, Artist artistToUpdate ){

        // 1- Est-ce que l'artiste à update est associé à mon user (est-ce que j'ai le droit de modifié l'artiste)
        Set<Artist> artists = findArtistByuserList(authenticatedUser.getId());

        if ( artists  != null && !artists.isEmpty()) {
            // => Récupération de la liste d'artiste du user
            Set<Artist> listArtist = authenticatedUser.getListArtist();
            // 2- Récupération de l'artiste à update par son id
            for (Artist artist : listArtist){
                if (idArtist == artist.getId()){
                    // 3- Update de l'artiste et sauvegarde en BDD
                    String updateMail = artistToUpdate.getContactMail();
                    if(updateMail != null){
                        artist.setContactMail(updateMail);
                    }
                   Set<DepartementAccepted> updateDepartement = artistToUpdate.getDepartments();
                    if (!updateDepartement.isEmpty())
                        for (DepartementAccepted d : updateDepartement){
                            if(d != null){
                                departementAcceptedRepository.save(d);
                            }
                        }
                        artist.setDepartments(updateDepartement);

                    String updatePhone = artistToUpdate.getContactPhone();
                    if(updatePhone != null){
                        artist.setContactPhone(updatePhone);
                    }
                    String updateDescription = artistToUpdate.getDescriptionArtist();
                    if (updateDescription != null){
                        artist.setDescriptionArtist(updateDescription);
                    }
                    String updateShortDescription = artistToUpdate.getShortDescriptionArtist();
                    if (updateShortDescription != null){
                        artist.setShortDescriptionArtist(updateShortDescription);
                    }
                    String updateUrl = artistToUpdate.getUrlSiteArtist();
                    if (updateUrl != null){
                        artist.setUrlSiteArtist(updateUrl);
                    }
                    String updateImage = artistToUpdate.getUrlImage();
                    if (updateImage != null){
                        artist.setUrlImage(updateImage);
                    }

                    artistRepository.save(artist);
                    return artist;
                }
                break;
            }

        }
        return null;


        // 4- Retourne l'artiste modifié

    }






}

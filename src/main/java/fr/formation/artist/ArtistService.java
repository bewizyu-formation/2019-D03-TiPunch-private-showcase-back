package fr.formation.artist;


import fr.formation.geo.model.DepartementAccepted;
import fr.formation.image.ImageStorageService;
import fr.formation.geo.services.DepartementAcceptedRepository;
import fr.formation.models.Artist;
import fr.formation.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * The type Artist service
 */
@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    private DepartementAcceptedRepository departementAcceptedRepository;

    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     *
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, DepartementAcceptedRepository departementAcceptedRepository) {
        this.artistRepository = artistRepository;
        this.departementAcceptedRepository = departementAcceptedRepository;

    }

    public List<Artist> getArtists(User user){

        List<Artist> artists = artistRepository.findAll();
       
        return  artists;
    }


    public Artist findArtistByNameArtist(String nameArtist){
        Artist artist = artistRepository.findArtistByNameArtist(nameArtist);
        return  artist;
    }
    public Artist getArtistById(Long id){
        Artist artist = artistRepository.findArtistById(id);
        if (artist != null) {
            return artist;
        }
        return  null;
    }






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
                    // 4- Retourne l'artiste modifié
                    artistRepository.save(artist);
                    return artist;
                }
                break;
            }

        }
        return null;




    }






}

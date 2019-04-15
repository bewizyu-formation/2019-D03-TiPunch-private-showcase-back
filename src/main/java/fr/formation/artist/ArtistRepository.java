package fr.formation.artist;

import fr.formation.geo.model.DepartementAccepted;
import fr.formation.models.Artist;
import fr.formation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Interface Artist Repository
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    /**
     * Find by artist name
     * @param nameArtist the name artist
     * @return the artist
     */
    public Artist findArtistByNameArtist(String nameArtist);

    public  Artist findArtistById( Long id);

    /**
     * Find all artist
     * @return the list artist
     */

    public List<Artist> findAll();


    /**
     * Delete artist by id
     * @param id the id
     */
    public void deleteArtistById(Long id);

    /**
     * Search artist by name if exist
     * @param nameArtist
     * @return boolean 
     */
    public boolean existsByNameArtist(String nameArtist); //A débatre


    /**
     * Find by artist username
     * @param username
     * @return
     */
   // public boolean existsByUsername(String username);


   // public Set<Artist> findArtistBycityArtist(String city);

    public  Artist findArtistByDepartments(DepartementAccepted codeDepartementArtist);


    @Query("Select artist from Artist join artist.user where user.id = user_list_id")
    public Artist findArtistByuserList();




}

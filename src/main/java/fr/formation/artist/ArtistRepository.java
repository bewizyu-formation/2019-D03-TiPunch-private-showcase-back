package fr.formation.artist;

import fr.formation.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
    public boolean existsByUsername(String username);

    public Artist findArtistsById(Long id);

}

package fr.formation.user;

import fr.formation.models.Artist;
import fr.formation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;


/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find by username user.
	 *
	 * @param username the username
	 *
	 * @return the user
	 */
	public User findByUsername(String username);

	public boolean existsByUsername(String username);

	//public Set<Artist> updateArtist(User authenticatedUser, Long idArtist, Artist artistToUpdate );



}

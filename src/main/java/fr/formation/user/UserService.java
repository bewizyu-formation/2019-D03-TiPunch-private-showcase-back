package fr.formation.user;

import fr.formation.artist.ArtistRepository;
import fr.formation.geo.model.DepartementAccepted;
import fr.formation.geo.services.CommuneService;
import fr.formation.geo.services.DepartementAcceptedRepository;
import fr.formation.geo.services.DepartementService;
import fr.formation.modelDto.ArtistDto;
import fr.formation.models.Artist;
import fr.formation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * The type User service.
 */
@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	private ArtistRepository artistRepository;
	private DepartementAcceptedRepository departementAcceptedRepository;
	private UserRoleRepository userRoleRepository;

	private PasswordEncoder passwordEncoder;

	private CommuneService communeService;
	private DepartementService departementService;
	private DepartementAccepted departementAccepted;

	/**
	 * Instantiates a new User service.
	 *
	 * @param userRepository     the user repository
	 * @param userRoleRepository the user role repository
	 */
	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder,
					   CommuneService communeService,
					   DepartementService departementService, ArtistRepository artistRepository,
					   DepartementAcceptedRepository departementAcceptedRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
		this.passwordEncoder = passwordEncoder;
		this.communeService = communeService;
		this.departementService = departementService;
		this.artistRepository = artistRepository;
		this.departementAcceptedRepository = departementAcceptedRepository;
	}

	/**
	 * transform a list of roles (as {@link String}) into a list of {@link GrantedAuthority}
	 *
	 * @param userRoles
	 *
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> transformToAuthorities(List<String> userRoles) {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user != null) {
			List<String> roles = userRoleRepository.findRoleByUserName(username);
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
					transformToAuthorities(roles));
		} else {
			throw new UsernameNotFoundException("No user exists with username: " + username);
		}

	}

	/**
	 * * Add a new user with the user repository
	 * @param username the username
	 * @param password the password
	 * @param mail the mail
	 * @param city the city
	 * @param roles the roles
	 */

	public boolean addNewUserAndArtist(String username, String password, String mail, String city , ArtistDto artistDto, String... roles) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMail(mail);
		user.setCity(city);

		List<LinkedHashMap> communes = communeService.getCommunes(city) ;
		List<LinkedHashMap> departements ;

		for ( LinkedHashMap <String ,String> c : communes){
			boolean cityApi =  c.get("nom").equalsIgnoreCase(city);
			if (cityApi){
				String codeDepartement =  c.get("codeDepartement");
				if (!codeDepartement.isEmpty()){
					user.setCodeDepartement(codeDepartement);
					departements = departementService.getDepartementByCode(codeDepartement);
					for (LinkedHashMap<String, String> d : departements){
						String nomDepartement = d.get("nom");
						user.setNameDepartement(nomDepartement);

					}
				}
			}

		}
		if(!userRepository.existsByUsername(user.getUsername())
				&& isValidPassword(user.getPassword() )){

		if(artistDto != null) {

			Artist artist = new Artist();
			Set<User> listUSer = new HashSet<>();
			Set<Artist> listArtist = new HashSet<>();
			DepartementAccepted departementAccepted = new DepartementAccepted();


			artist.setNameArtist(artistDto.getNameArtist());
			artist.setDescriptionArtist(artistDto.getDescriptionArtist());

			departementAccepted.setNomDepartements(user.getNameDepartement());

			Set<DepartementAccepted> listDepartementAccepeted = new HashSet<>();

			listDepartementAccepeted.add(departementAccepted);
			artist.setDepartments(listDepartementAccepeted);
			departementAcceptedRepository.save(departementAccepted);

			listUSer.add(user);
			artist.setUserList(listUSer);
			listArtist.add(artist);
			user.setListArtist(listArtist);
			 artistRepository.save(artist);
		}



			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user = userRepository.save(user);


			for (String role : roles) {

				UserRole userRole = new UserRole();
				userRole.setRole(role);
				userRole.setUserId(user.getId());

				userRoleRepository.save(userRole);
			}
			return true;

		}

		return false;

	}

	public User getUserByUsername(String name) {
		User user = userRepository.findByUsername(name);
		return user;
	}
	public User getUser(User user){
		user = userRepository.findByUsername(user.getUsername());
		return user;

	}

	/**
	 * checked password with 8 character minimum, 1 MAJ, 1 number
	 * @param password
	 * @return boolean
	 */
	public boolean isValidPassword(String password){

		return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$");
	}

	public boolean userExist(String username){
		if (userRepository.existsByUsername(username)){
			return true;
		}
		return false;
	}


	}

package fr.formation.artist;

import fr.formation.geo.model.Commune;
import fr.formation.geo.model.DepartementAccepted;
import fr.formation.geo.services.CommuneService;
import fr.formation.models.Artist;
import fr.formation.user.UserRole;
import fr.formation.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Artist service
 */
@Service
public class ArtistService {

    private ArtistRepository artistRepository;
    private UserRoleRepository userRoleRepository;
    private CommuneService communeService;
    private Artist artist;
    private Commune commune;
    private DepartementAccepted departementAccepted;
    private PasswordEncoder passwordEncoder;



    /**
     * Instanciates a new Artist service.
     *
     * @param artistRepository     the artist repository
     *
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, UserRoleRepository userRoleRepository,
                         PasswordEncoder passwordEncoder, CommuneService communeService) {
        this.artistRepository = artistRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.communeService = communeService;


    }

    public boolean addNewArtist(String username, String password, String mail,
                             String city, String artistName,
                             String description, String... roles) {
        Artist artist = new Artist();
        artist.setUsername(username);
        artist.setPasswordArtist(password);
        artist.setMailArtist(mail);
        artist.setCityArtist(city);
        List<Commune> communes = communeService.getCommunes(city);
        for (Commune c : communes){
            if (c.getNom().equals(artist.getCityArtist())){
              String codeDepartementBase = c.getCodeDepartement();

              artist.setCodeDepartement(codeDepartementBase);

            }
        }
        System.out.println(" LE DEPARTEMENT : " + artist.getCodeDepartement());

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

    public List<Artist> getArtists(){
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

    public Set<Artist>findArtistByCity(String city){
        List<Commune> communeList  =  communeService.getCommunes(city); // recupére la liste de commune du user
        Set<DepartementAccepted> codeDepartement = artist.getDepartments(); // recupère la list des departements lié aux artistes
        List<String> listDepartementApi= new ArrayList<>();

       for ( Commune c: communeList){

           listDepartementApi = communeList.stream().map(commune -> commune.getCodeDepartement()).collect(Collectors.toList());
       }
       Set<Artist> listArtists = new HashSet<>();
       for (DepartementAccepted codeDepartementArtist: codeDepartement){
           for (String codeDepartementApi : listDepartementApi){
               if (codeDepartementArtist.toString().equals(codeDepartementApi)){
                   listArtists.add(artistRepository.findArtistByDepartments(codeDepartementArtist));

               }

           }
       }
       return listArtists;

    }




}

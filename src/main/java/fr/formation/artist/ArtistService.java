package fr.formation.artist;

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
     * @param artistRepository the artist repository
     * @param artistRoleRepository the artist role repository
     */
    @Autowired
    public ArtistService(ArtistRepository artistRepository, ArtistRoleRepository artistRoleRepository){
        this.artistRepository = artistRepository;
        this.artistRepository = artistRepository;
    }
}

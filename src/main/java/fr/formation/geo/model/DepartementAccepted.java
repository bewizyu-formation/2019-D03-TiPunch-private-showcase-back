package fr.formation.geo.model;

import fr.formation.models.Artist;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="departementAccepted")
public class DepartementAccepted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Artist artist;

    private String nomDepartements;


    /**
     * Constructors
     */
    public DepartementAccepted() {
    }

    public DepartementAccepted(Long id, Artist artist, String nomDepartements) {
        this.id = id;
        this.artist = artist;
        this.nomDepartements = nomDepartements;
    }

    /**
     * Getter
     */
    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getCodeDepartements() {
        return nomDepartements;
    }

    /**
     * Setter
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setNomDepartements(String nomDepartements) {
        this.nomDepartements = nomDepartements;
    }
}

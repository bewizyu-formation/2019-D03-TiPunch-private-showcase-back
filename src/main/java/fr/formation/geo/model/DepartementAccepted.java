package fr.formation.geo.model;

import fr.formation.models.Artist;

import javax.persistence.*;

@Entity
@Table(name ="departementAccepted")
public class DepartementAccepted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Artist artist;

    private Integer departements;

    /**
     * Constructors
     */
    public DepartementAccepted() {
    }

    public DepartementAccepted(Long id, Artist artist, Integer departements) {
        this.id = id;
        this.artist = artist;
        this.departements = departements;
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

    public Integer getDepartements() {
        return departements;
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

    public void setDepartements(Integer departements) {
        this.departements = departements;
    }
}

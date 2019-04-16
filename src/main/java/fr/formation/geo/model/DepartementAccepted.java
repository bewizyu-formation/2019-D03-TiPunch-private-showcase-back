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

    private String nomDepartements;

    /**
     * Constructors
     */
    public DepartementAccepted() {
    }

    public DepartementAccepted(Long id, String nomDepartements) {
        this.id = id;
        this.nomDepartements = nomDepartements;
    }

    /**
     * Getter
     */
    public Long getId() {
        return id;
    }

    public String getNomDepartements() {
        return nomDepartements;
    }

    /**
     * Setter
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setNomDepartements(String nomDepartements) {
        this.nomDepartements = nomDepartements;
    }
}

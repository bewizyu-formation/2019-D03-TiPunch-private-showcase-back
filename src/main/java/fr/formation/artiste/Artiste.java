package fr.formation.artiste;


import fr.formation.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Artiste")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ARTISTE")
public class Artiste extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArtiste;
    private String nameArtiste;
    private String descriptionArtiste;
    private Integer noteEvent;

    /**
     * Constructeurs
     */

    public Artiste() {
    }

    public Artiste(String nameArtiste, String descriptionArtiste, Integer noteEvent) {
        this.nameArtiste = nameArtiste;
        this.descriptionArtiste = descriptionArtiste;
        this.noteEvent = noteEvent;
    }

    /**
     * Getteur Artiste
     */
    public Long getIdArtiste() {
        return idArtiste;
    }


    public String getNameArtiste() {
        return nameArtiste;
    }

    public String getDescriptionArtiste() {
        return descriptionArtiste;
    }

    public Integer getNoteEvent() {
        return noteEvent;
    }


    /**
     * Setteur Artiste
     */
    public void setIdArtiste(Long idArtiste) {
        this.idArtiste = idArtiste;
    }


    public void setNameArtiste(String nameArtiste) {
        this.nameArtiste = nameArtiste;
    }

    public void setDescriptionArtiste(String descriptionArtiste) {
        this.descriptionArtiste = descriptionArtiste;
    }

    public void setNoteEvent(Integer noteEvent) {
        this.noteEvent = noteEvent;
    }
}

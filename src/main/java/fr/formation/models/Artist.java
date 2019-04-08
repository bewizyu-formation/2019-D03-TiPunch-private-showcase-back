package fr.formation.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameArtist;

    private String username;

    private String passwordArtist;

    private String mailArtist;

    private String cityArtist;


    private String descriptionArtist;

    private Integer nbVote;

    private Integer noteArtist;

    @ManyToMany(mappedBy = "listArtist")
    private Set<User> userList;


    @OneToOne
    private Event eventBooked; // nommer eventBooked mais je sais pas si c'est le mieux

    /**
     * Constructeurs
     */

    public Artist() {
    }

    public Artist(String nameArtist, String mailArtist,
                  String cityArtist, String descriptionArtist,
                  Integer nbVote, Integer noteArtist,
                  Set<User> userList) {
        this.nameArtist = nameArtist;
        this.mailArtist = mailArtist;
        this.cityArtist = cityArtist;
        this.descriptionArtist = descriptionArtist;
        this.nbVote = nbVote;
        this.noteArtist = noteArtist;
        this.userList = userList;
    }

    /**
     * Getteur Artist
     */
    public Long getId() {
        return id;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public String getMailArtist() {
        return mailArtist;
    }

    public String getCityArtist() {
        return cityArtist;
    }

    public String getDescriptionArtist() {
        return descriptionArtist;
    }

    public Integer getNbVote() {
        return nbVote;
    }

    public Integer getNoteArtist() {
        return noteArtist;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public Event getEventBooked() {
        return eventBooked;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordArtist() {
        return passwordArtist;
    }

    /**
     * Setteur Artist
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public void setMailArtist(String mailArtist) {
        this.mailArtist = mailArtist;
    }

    public void setCityArtist(String cityArtist) {
        this.cityArtist = cityArtist;
    }

    public void setDescriptionArtist(String descriptionArtist) {
        this.descriptionArtist = descriptionArtist;
    }

    public void setNbVote(Integer nbVote) {
        this.nbVote = nbVote;
    }

    public void setNoteArtist(Integer noteArtist) {
        this.noteArtist = noteArtist;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public void setEventBooked(Event eventBooked) {
        this.eventBooked = eventBooked;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordArtist(String passwordArtist) {
        this.passwordArtist = passwordArtist;
    }
}

package fr.formation.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameArtist;

    private String mailArtist;

    private String cityArtist;


    private String descriptionArtist;

    private Integer nbVote;

    private Integer noteArtist;

    @ManyToMany(mappedBy = "listArtist")
    private ArrayList<User> userList ;



    /**
     * Constructeurs
     */

    public Artist() {
    }

    public Artist(String nameArtist, String mailArtist,
                  String cityArtist, String descriptionArtist,
                  Integer nbVote, Integer noteArtist,
                  ArrayList<User> userList) {
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

    public ArrayList<User> getUserList() {
        return userList;
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

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}

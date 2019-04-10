package fr.formation.models;

import fr.formation.geo.model.DepartementAccepted;

import javax.persistence.*;

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

    @OneToMany(mappedBy = "artist")
    private  Set<DepartementAccepted> departments;

    private String codeDepartement;

    private String descriptionArtist;

    private Integer nbVote;

    private Integer noteArtist;

    @ManyToMany(mappedBy = "listArtist")
    private Set<User> userList;

    @OneToOne
    private Event eventBooked;
    
    private String urlImage;
    
    private String shortDescriptionArtist;
    
    private String contactPhone;
    
    private String contactMail;
    
    private String urlSiteArtist;

    /**
     * Constructeurs
     */

    public Artist() {
    }

    public Artist(String nameArtist, String username, String passwordArtist, String mailArtist, String cityArtist, Set<DepartementAccepted> departments, String descriptionArtist) {
        this.nameArtist = nameArtist;
        this.username = username;
        this.passwordArtist = passwordArtist;
        this.mailArtist = mailArtist;
        this.cityArtist = cityArtist;
        this.departments = departments;
        this.descriptionArtist = descriptionArtist;
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

    public Set<DepartementAccepted> getDepartments() {
        return departments;
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

    public String getUrlImage() {
        return urlImage;
    }

    public String getShortDescriptionArtist() {
        return shortDescriptionArtist;
    }

    public String getContactMail() {
        return contactMail;
    }

    public String getUrlSiteArtist() {
        return urlSiteArtist;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getContactPhone() {
        return contactPhone;
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

    public void setDepartments(Set<DepartementAccepted> departments) {
        this.departments = departments;
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

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setShortDescriptionArtist(String shortDescriptionArtist) {
        this.shortDescriptionArtist = shortDescriptionArtist;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public void setUrlSiteArtist(String urlSiteArtist) {
        this.urlSiteArtist = urlSiteArtist;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }
}


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

    @Column(name= "nameArtist")
    private String nameArtist;

    @Column(name ="departments")
    @OneToMany(mappedBy = "artist")
    private  Set<DepartementAccepted> departments;

    @Column(name = "codeDepartement")
    private String codeDepartement;

    @Column(name="nameDepartement")
    private String nameDepartement;

    @Column(name="descriptionArtist")
    private String descriptionArtist;

    @Column(name="nbVote")
    private Integer nbVote;

    @Column(name="noteArtist")
    private Integer noteArtist;


    @Column(name="userList")
    @ManyToMany(mappedBy = "listArtist")
    private Set<User> userList;



    @OneToOne
    private Event eventBooked;

    @Column(name="urlImage")
    private String urlImage;

    @Column(name="shortDescriptionArtist")
    private String shortDescriptionArtist;

    @Column(name="contactPhone")
    private String contactPhone;

    @Column(name="contactMail")
    private String contactMail;



    @Column(name="urlSiteArtist")
    private String urlSiteArtist;

    /**
     * Constructeurs
     */

    public Artist() {
    }

    public Artist(String nameArtist,   Set<DepartementAccepted> departments, String descriptionArtist) {
        this.nameArtist = nameArtist;
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


    public String getContactMail() {
        return contactMail;
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


    public String getUrlImage() {
        return urlImage;
    }

    public String getShortDescriptionArtist() {
        return shortDescriptionArtist;
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

    public String getNameDepartement() {
        return nameDepartement;
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

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
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


    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setShortDescriptionArtist(String shortDescriptionArtist) {
        this.shortDescriptionArtist = shortDescriptionArtist;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setUrlSiteArtist(String urlSiteArtist) {
        this.urlSiteArtist = urlSiteArtist;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public void setNameDepartement(String nameDepartement) {
        this.nameDepartement = nameDepartement;
    }
}


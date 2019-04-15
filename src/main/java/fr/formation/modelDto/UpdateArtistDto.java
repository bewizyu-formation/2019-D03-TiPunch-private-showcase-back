package fr.formation.modelDto;

import fr.formation.geo.model.DepartementAccepted;

import java.util.Set;

public class UpdateArtistDto {
    private Long id;
    private String nameArtist;
    private Set<DepartementAccepted> departments;
    private String descriptionArtist;
    private Integer nbVote;
    private Integer noteArtist;
    private String urlImage;
    private String shortDescriptionArtist;
    private String contactPhone;
    private String contactMail;
    private String urlSiteArtist;
    private Boolean matchingUser;

    public UpdateArtistDto(Long id, String nameArtist, Set<DepartementAccepted> departments, String descriptionArtist, Integer nbVote, Integer noteArtist, String urlImage, String shortDescriptionArtist, String contactPhone, String contactMail, String urlSiteArtist, Boolean matchingUser) {
        this.id = id;
        this.nameArtist = nameArtist;
        this.departments = departments;
        this.descriptionArtist = descriptionArtist;
        this.nbVote = nbVote;
        this.noteArtist = noteArtist;
        this.urlImage = urlImage;
        this.shortDescriptionArtist = shortDescriptionArtist;
        this.contactPhone = contactPhone;
        this.contactMail = contactMail;
        this.urlSiteArtist = urlSiteArtist;
        this.matchingUser = matchingUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public Set<DepartementAccepted> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartementAccepted> departments) {
        this.departments = departments;
    }

    public String getDescriptionArtist() {
        return descriptionArtist;
    }

    public void setDescriptionArtist(String descriptionArtist) {
        this.descriptionArtist = descriptionArtist;
    }

    public Integer getNbVote() {
        return nbVote;
    }

    public void setNbVote(Integer nbVote) {
        this.nbVote = nbVote;
    }

    public Integer getNoteArtist() {
        return noteArtist;
    }

    public void setNoteArtist(Integer noteArtist) {
        this.noteArtist = noteArtist;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getShortDescriptionArtist() {
        return shortDescriptionArtist;
    }

    public void setShortDescriptionArtist(String shortDescriptionArtist) {
        this.shortDescriptionArtist = shortDescriptionArtist;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getUrlSiteArtist() {
        return urlSiteArtist;
    }

    public void setUrlSiteArtist(String urlSiteArtist) {
        this.urlSiteArtist = urlSiteArtist;
    }

    public Boolean getMatchingUser() {
        return matchingUser;
    }

    public void setMatchingUser(Boolean matchingUser) {
        this.matchingUser = matchingUser;
    }
}

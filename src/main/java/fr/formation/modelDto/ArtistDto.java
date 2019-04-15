package fr.formation.modelDto;



public class ArtistDto {


    private Long id;
    private String nameArtist;
    private String descriptionArtist;
    private String urlImage;
    private byte[] image;
    private Integer noteArtist;
    private String shortDescriptionArtist;
    private String contactPhone;
    private String contactMail;
    private String urlSiteArtist;

    /**
     * Constructeurs
     */

    public ArtistDto() {
    }

    public ArtistDto(String nameArtist, String descriptionArtist) {
        this.nameArtist = nameArtist;
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

    public String getDescriptionArtist() {
        return descriptionArtist;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Integer getNoteArtist() { return noteArtist; }

    public String getShortDescriptionArtist() { return shortDescriptionArtist; }

    public String getContactPhone() { return contactPhone; }

    public String getContactMail() { return contactMail; }

    public String getUrlSiteArtist() { return urlSiteArtist; }

    /**
     * Setteur Artist
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public void setDescriptionArtist(String description) {
        this.descriptionArtist = description;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setNoteArtist(Integer noteArtist) { this.noteArtist = noteArtist; }

    public void setShortDescriptionArtist(String shortDescriptionArtist) {
        this.shortDescriptionArtist = shortDescriptionArtist; }

    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public void setContactMail(String contactMail) { this.contactMail = contactMail; }

    public void setUrlSiteArtist(String urlSiteArtist) { this.urlSiteArtist = urlSiteArtist; }
}



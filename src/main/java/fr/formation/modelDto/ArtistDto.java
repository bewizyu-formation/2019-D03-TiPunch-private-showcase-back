package fr.formation.modelDto;



public class ArtistDto {


    private Long id;
    private String nameArtist;
    private String username;
    private String passwordArtist;
    private String mailArtist;
    private String cityArtist;
    private String descriptionArtist;

    /**
     * Constructeurs
     */

    public ArtistDto() {
    }

    public ArtistDto(String nameArtist, String mailArtist,
                  String cityArtist, String descriptionArtist) {
        this.nameArtist = nameArtist;
        this.mailArtist = mailArtist;
        this.cityArtist = cityArtist;
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

    public String getDescriptionArtist() {
        return descriptionArtist;
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

    public void setMailArtist(String mail) {
        this.mailArtist = mail;
    }

    public void setCityArtist(String city) {
        this.cityArtist = city;
    }

    public void setDescriptionArtist(String description) {
        this.descriptionArtist = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordArtist(String password) {
        this.passwordArtist = password;
    }
}



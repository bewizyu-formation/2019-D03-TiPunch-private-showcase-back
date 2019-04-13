package fr.formation.modelDto;



public class ArtistDto {


    private Long id;
    private String nameArtist;
    private String descriptionArtist;

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

}



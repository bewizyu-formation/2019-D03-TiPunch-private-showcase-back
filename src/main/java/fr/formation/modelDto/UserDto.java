package fr.formation.modelDto;

import fr.formation.models.Artist;
import fr.formation.models.Event;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * The type User.
 */

public class UserDto {



        private Long id;
        private String username;
        private String password;
        private String mail;
        private String city;
        private ArtistDto artistDto;




        /**
         * Constructors
         */
        public UserDto() {
        }

        public UserDto(Long id, String username, String password, String mail, String city, Set<Artist> listArtist, Set<Event> listEvents, @NotNull Event eventOrganized) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.mail = mail;
            this.city = city;
        }

        /**
         * Getter
         *
         *
         */
        public Long getId() {
            return id;
        }
        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
        public String getMail() {
            return mail;
        }
        public String getCity() {
            return city;
        }

    public ArtistDto getArtistDto() {
        return artistDto;
    }

    /**
         * Setter
         *
         *
         */
        public void setId(Long id) {
            this.id = id;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setMail(String mail) {
            this.mail = mail;
        }
        public void setCity(String city) {
            this.city = city;
        }

    public void setArtistDto(ArtistDto artistDto) {
        this.artistDto = artistDto;
    }
}



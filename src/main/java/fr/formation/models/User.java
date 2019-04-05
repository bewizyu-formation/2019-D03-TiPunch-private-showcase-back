package fr.formation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The type User.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "city")
    private String city;

    @ManyToMany
    private Set<Artist> listArtist;

    @ManyToMany
    private Set<Event> listEvents;

    @NotNull
    @OneToOne
    private Event eventOrganized;


    /**
     * Constructors
     */
    public User() {
    }

    public User(Long id, String username, String password, String mail, String city, Set<Artist> listArtist, Set<Event> listEvents, @NotNull Event eventOrganized) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.city = city;
        this.listArtist = listArtist;
        this.listEvents = listEvents;
        this.eventOrganized = eventOrganized;
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
    public Set<Artist> getListArtist() {
        return listArtist;
    }
    public Set<Event> getListEvents() {
        return listEvents;
    }
    public Event getEventOrganized() {
        return eventOrganized;
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
    public void setListArtist(Set<Artist> listArtist) {
        this.listArtist = listArtist;
    }
    public void setListEvents(Set<Event> listEvents) {
        this.listEvents = listEvents;
    }
    public void setEventOrganized(Event eventOrganized) {
        this.eventOrganized = eventOrganized;
    }
}

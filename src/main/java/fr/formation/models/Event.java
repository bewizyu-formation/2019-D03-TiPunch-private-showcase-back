package fr.formation.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne
    private User organisateurEvent;

    @Max(100)
    private Integer numberOfPeopleEvent;

    private LocalDateTime dateEvent;

    @NotNull
    @OneToOne
    private Artist artistAtTheEvent;

    @ManyToMany(mappedBy = "listEvents")
    private Set<User> listUsers;

    /**
     * Constructors Event
     */
    public Event() {
    }

    public Event(User organisateurEvent, Integer numberOfPeopleEvent,
                 LocalDateTime dateEvent, Artist artistAtTheEvent, Set<User> listUsers) {
        this.organisateurEvent = organisateurEvent;
        this.numberOfPeopleEvent = numberOfPeopleEvent;
        this.dateEvent = dateEvent;
        this.artistAtTheEvent = artistAtTheEvent;
        this.listUsers = listUsers;
    }

    /**
     * Getteur
     */
    public Long getId() {
        return id;
    }

    public User getOrganisateurEvent() {
        return organisateurEvent;
    }

    public Integer getNumberOfPeopleEvent() {
        return numberOfPeopleEvent;
    }

    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    public Artist getArtistAtTheEvent() {
        return artistAtTheEvent;
    }

    public Set<User> getListUsers() {
        return listUsers;
    }

    /**
     * Setteur
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrganisateurEvent(User organisateurEvent) {
        this.organisateurEvent = organisateurEvent;
    }

    public void setNumberOfPeopleEvent(Integer numberOfPeopleEvent) {
        this.numberOfPeopleEvent = numberOfPeopleEvent;
    }

    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    public void setArtistAtTheEvent(Artist artistAtTheEvent) {
        this.artistAtTheEvent = artistAtTheEvent;
    }

    public void setListUsers(Set<User> listUsers) {
        this.listUsers = listUsers;
    }
}

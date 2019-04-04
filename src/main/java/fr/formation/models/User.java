package fr.formation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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


	/**
	 * Constructors
	 */
	public User() {
	}


	public User(String username, String password, String mail, String city, Set<Artist> listArtist) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.city = city;
		this.listArtist = listArtist;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Gets mail
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets mail
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets city
	 * @return city
	 */

	public String getCity() {
		return city;
	}

	/**
	 * Sets city
	 * @param city
	 */

	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * Gets list Artist
	 * @return list artist
	 */
	public Set<Artist> getListArtist() {
		return listArtist;
	}

	/**
	 * Sets list artist
	 * @param listArtist
	 */
	public void setListArtist(Set<Artist> listArtist) {
		this.listArtist = listArtist;
	}

	/**
	 *  gets lsit event
	 * @return list Events
	 */
	public Set<Event> getListEvents() {
		return listEvents;
	}

	/**
	 * Sets list event
	 * @param listEvents
	 */

	public void setListEvents(Set<Event> listEvents) {
		this.listEvents = listEvents;
	}
}

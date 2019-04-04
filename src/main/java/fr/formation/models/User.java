package fr.formation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
	private ArrayList<Artiste> listArtist;


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
	 * Stes city
	 * @param city
	 */

	public void setCity(String city) {
		this.city = city;
	}
}

package fr.formation.artist;

import javax.persistence.*;

/**
 * The Type Artist role
 */
@Entity
@Table(name="artist_role")
public class ArtistRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name ="artistId")
    private Long artistId;

    @Column(name = "role")
    private String role;

    /**
     * Constructor
     */
    public ArtistRole() {
    }

    /**
     * Getters
     *
     */
    public Integer getRoleId() { return roleId; }

    public Long getArtistId() { return artistId; }

    public String getRole() { return role; }

    /**
     * Setters
     *
     */
    public void setRole(String role) { this.role = role; }

    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public void setArtistId(Long artistId) { this.artistId = artistId; }
}

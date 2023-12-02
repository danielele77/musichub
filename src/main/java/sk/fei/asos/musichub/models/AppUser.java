package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "Users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "photo")
    private String photo;

    @Column(name = "salt")
    private String salt;

    @Column(name = "email")
    private String email;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "playlistId")
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Playlist> playlistId;

    public AppUser(long id, String username, String password, String photo, String salt, String email, Boolean isAdmin, String fullName, List<Playlist> playlistId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.salt = salt;
        this.email = email;
        this.isAdmin = isAdmin;
        this.fullName = fullName;
        this.playlistId = new HashSet<>();
    }
}

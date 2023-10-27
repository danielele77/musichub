package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "email")
    private String email;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "playlistId")
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Playlist> playlistId;


    public AppUser(String login, String password) {
        this.username = login;
        this.password = password;
    }
}
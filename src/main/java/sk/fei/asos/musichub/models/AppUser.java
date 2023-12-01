package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private List<Playlist> playlistId;

//    public AppUser(String username, String email, String password){
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
}

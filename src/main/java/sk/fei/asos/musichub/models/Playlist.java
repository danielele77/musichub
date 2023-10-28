package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "playlist_id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

//    @ManyToMany(mappedBy = "playlists", cascade = CascadeType.REMOVE)
    @ManyToMany
    @JoinTable(name="song2playlist",
            joinColumns = @JoinColumn(name="playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs;

}

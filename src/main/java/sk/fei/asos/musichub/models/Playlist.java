package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(name="song2playlist",
            joinColumns = @JoinColumn(name="playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs;

    public Playlist(String name, AppUser user) {
        this.name = name;
        this.user = user;
        this.songs = new HashSet<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

}

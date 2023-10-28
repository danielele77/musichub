package sk.fei.asos.musichub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "song_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "artist")
    private String artist;

    @Column(name = "coverPhoto")
    private String coverPhoto;

    @Column(name = "sourceName")
    private String sourceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @ManyToMany(mappedBy = "songs",fetch = FetchType.EAGER)
    private Set<Playlist> playlists;

    public Song(){
        this.playlists = new HashSet<>();
    }
}

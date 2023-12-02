package sk.fei.asos.musichub.models.responses;

import jakarta.persistence.*;
import lombok.Getter;
import sk.fei.asos.musichub.models.Genre;
import sk.fei.asos.musichub.models.Playlist;
import sk.fei.asos.musichub.models.Song;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class SongResponse {


    private Long id;


    private String name;


    private String lyrics;


    private String artist;


    private String coverPhoto;


    private String sourceName;



    private Genre genre;


    private List<PlaylistResponse> playlists;

    public SongResponse(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        this.lyrics = song.getLyrics();
        this.artist = song.getArtist();
        this.coverPhoto = song.getCoverPhoto();
        this.genre = song.getGenre();
        this.playlists = song.getPlaylists().stream().map(PlaylistResponse::new).collect(Collectors.toList());
    }
}

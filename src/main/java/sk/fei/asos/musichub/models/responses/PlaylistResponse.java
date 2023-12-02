package sk.fei.asos.musichub.models.responses;

import jakarta.persistence.*;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.Playlist;
import sk.fei.asos.musichub.models.Song;

import java.util.Set;
import java.util.stream.Collectors;

public class PlaylistResponse {


    private long id;

    private String name;

    private long user;

    private Set<Long> songs;

    public PlaylistResponse(Playlist playlist){
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.user = playlist.getUser().getId();
//        this.songs = playlist.getSongs().stream().map(Song::getId).collect(Collectors.toSet());
    }
}

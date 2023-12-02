package sk.fei.asos.musichub.services;

import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.Playlist;

import java.util.Optional;

public interface PlaylistService {
    Playlist createPlaylist(long userId, String playlistName) throws ConflictException, NotFoundException;

    Playlist addSong(String playlistId, long songId);

    Playlist getById(long playlistId) throws NotFoundException;
//    List<Playlist> getAllPlaylistsByUsername(String username);
//    Playlist createPlaylist(String username, String playlistName);
//    List<Playlist> deletePlaylist(String username, String playlistName);
//    Playlist addSongToPlaylist(String username, String playlistName, String songId);
//    Playlist deleteSongFromPlaylist(String username, String playlistName, String songId);
//
//    Playlist getPlaylistById(long playlistId);
}

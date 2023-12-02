package sk.fei.asos.musichub.services;

import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.Playlist;

import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(long userId, String playlistName) throws ConflictException, NotFoundException;

    Playlist addSong(long playlistId, long songId) throws NotFoundException, ConflictException;

    Playlist getById(long playlistId) throws NotFoundException;
    List<Playlist> getUserPlaylists(long userId) throws NotFoundException;

    Playlist rename(long playlistId,String name) throws NotFoundException, ConflictException;

    Playlist removeSong(long playlistId, long songId) throws NotFoundException;

//    List<Playlist> getAllPlaylistsByUsername(String username);
//    Playlist createPlaylist(String username, String playlistName);
//    List<Playlist> deletePlaylist(String username, String playlistName);
//    Playlist addSongToPlaylist(String username, String playlistName, String songId);
//    Playlist deleteSongFromPlaylist(String username, String playlistName, String songId);
//
//    Playlist getPlaylistById(long playlistId);
}

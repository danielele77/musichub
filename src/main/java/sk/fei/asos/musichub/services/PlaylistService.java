package sk.fei.asos.musichub.services;

import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.Playlist;

import java.util.Optional;

public interface PlaylistService {
    Playlist createPlaylist(long userId, String playlistName) throws ConflictException, NotFoundException;

    Playlist addSong(long playlistId, long songId) throws NotFoundException, ConflictException;

    Playlist getById(long playlistId) throws NotFoundException;

    Playlist rename(long playlistId,String name) throws NotFoundException, ConflictException;

}

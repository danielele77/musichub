package sk.fei.asos.musichub.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.Playlist;
import sk.fei.asos.musichub.models.Song;
import sk.fei.asos.musichub.repositories.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PlaylistServiceImp implements PlaylistService{


    private final PlaylistRepository playlistRepository;

    private final UserManagementService userManagementService;

    private final SongService songService;

    @Override
    public Playlist createPlaylist(long userId, String playlistName) throws ConflictException, NotFoundException {
        AppUser appUser = userManagementService.getById(userId);
        List<Playlist> playlists =  appUser.getPlaylistId().stream().filter(p-> p.getName().equals(playlistName)).toList();
        if (!playlists.isEmpty()) {
            throw new ConflictException();
        }

        return playlistRepository.save(new Playlist(playlistName,appUser));
    }

    @Override
    public Playlist addSong(long playlistId, long songId) throws NotFoundException, ConflictException {
        Playlist playlist = this.getById(playlistId);
        Song song = songService.getSongById(songId);
        List<Song> songs = playlist.getSongs().stream().filter(s -> s.equals(song)).toList();
        if(!songs.isEmpty()){
            throw new ConflictException();
        }
        playlist.addSong(song);
        return playlistRepository.save(playlist);
    }


    @Override
    public Playlist getById(long playlistId) throws NotFoundException {
        Playlist playlist = playlistRepository.findPlaylistById(playlistId);
        if (playlist == null){
            throw new NotFoundException();
        }
        return playlist;
    }

    @Override
    public Playlist rename(long playlistId, String name) throws NotFoundException, ConflictException {
        Playlist playlist = this.getById(playlistId);
        if (playlist.getName().equals(name))
            throw new ConflictException();
        playlist.setName(name);
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist removeSong(long playlistId, long songId) throws NotFoundException {
        Playlist playlist = this.getById(playlistId);
        Song song = songService.getSongById(songId);
        List<Song> songs = playlist.getSongs().stream().filter(s -> s.equals(song)).toList();
        if(songs.isEmpty()){
            throw new NotFoundException();
        }
        playlist.getSongs().remove(song);
        return playlistRepository.save(playlist);

    }

    @Override
    public void detele(long playlistId) throws NotFoundException {
        playlistRepository.delete(this.getById(playlistId));
    }

    @Override
    public List<Playlist> getUserPlaylists(long userId) throws NotFoundException{
        return playlistRepository.findPlaylistByUserId(userId);
    }
}

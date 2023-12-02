package sk.fei.asos.musichub.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.Playlist;
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
    public Playlist addSong(String playlistId, long songId) {
        return null;
    }


    @Override
    public Playlist getById(long playlistId) throws NotFoundException {
        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        if (playlist.isPresent()){
            return playlist.get();
        }
        throw new NotFoundException();
    }
}

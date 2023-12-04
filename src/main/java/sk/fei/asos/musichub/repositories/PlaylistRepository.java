package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fei.asos.musichub.models.Playlist;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {

    List<Playlist> findPlaylistByUserId(Long userId);


//
//    List<Playlist> findAllByUserAndName(AppUser appUser, String playlistName);
//
//    Playlist createPlaylist(String username, String playlistName);
//
//    void deletePlaylist(String username, String playlistName);
//
//    Playlist addSongToPlaylist(String username, String playlistName, String songId);
//
////    Playlist deleteSongFromPlaylist(String username, String playlistName, String songId);
////
////    Playlist findPlaylistById(long playlistId);

    Playlist findPlaylistById(long playlistId);

}

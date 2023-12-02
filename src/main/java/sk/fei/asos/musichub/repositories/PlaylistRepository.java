package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.Playlist;
import sk.fei.asos.musichub.models.Song;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
//    List<Playlist> findAllByUser(AppUser appUser);
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

}

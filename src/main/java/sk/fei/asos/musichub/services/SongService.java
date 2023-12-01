package sk.fei.asos.musichub.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.asos.musichub.models.Genre;
import sk.fei.asos.musichub.models.Song;

import java.util.List;

public interface SongService {

    Resource loadSongAsResource(String songName);
    void uploadSong(MultipartFile songFile);

    List<Song> getAllSongs();

    List<Song> getAllSongsByGenre(Genre genre);
}

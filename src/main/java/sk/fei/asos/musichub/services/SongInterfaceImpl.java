package sk.fei.asos.musichub.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.asos.musichub.models.Song;
import sk.fei.asos.musichub.repositories.SongRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
@Slf4j
public class SongInterfaceImpl implements SongInterface {

    public static String SONGS_LOCATION = System.getProperty("user.dir") + "\\src\\main\\resources\\songs\\".replace('\\', File.separatorChar);
    private final SongRepository songRepository;

    @Autowired
    public SongInterfaceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Resource loadSongAsResource(String songResourceName) {
        String path = SONGS_LOCATION + songResourceName;
        Resource songResource = new FileSystemResource(path);
        return songResource;
    }

    @Override
    public void uploadSong(MultipartFile uploadedSong) {
        String songName = uploadedSong.getOriginalFilename();
        File songFile = new File(SONGS_LOCATION + songName);
        log.debug("Song " + songName);
        try {
            uploadedSong.transferTo(songFile);
        } catch (IOException e) {
            System.out.println(e.toString());
//            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getAllSongsByGenre(String genre) {
        return genre == null ? songRepository.findAll() : songRepository.findAllByGenre(genre);
    }


}

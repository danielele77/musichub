package sk.fei.asos.musichub.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.asos.musichub.models.Song;
import sk.fei.asos.musichub.services.SongInterfaceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongInterfaceImpl songService;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> allSongs = songService.getAllSongs();
        return allSongs != null ? ResponseEntity.ok(allSongs) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/songDownload/{songResourceName:.+\\.mp3}")
    public ResponseEntity<Resource> getSongResource(@PathVariable String songResourceName) {
        Resource songResource = songService.loadSongAsResource(songResourceName);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(songResource);
    }
}

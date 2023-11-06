package sk.fei.asos.musichub.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.asos.musichub.models.Song;
import sk.fei.asos.musichub.services.SongInterfaceImpl;

import java.util.List;

@RestController
@RequestMapping("/song")
@RequiredArgsConstructor
public class SongController {

    private final SongInterfaceImpl songService;

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> allSongs = songService.getAllSongs();
        return allSongs != null ? ResponseEntity.ok(allSongs) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("all/{genre}")
    public ResponseEntity<List<Song>> getSongsByGenre(@PathVariable String genre){
        List<Song> songs = songService.getAllSongsByGenre(genre);
        return songs != null ? ResponseEntity.ok(songs) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/download/{songResourceName:.+\\.mp3}")
    public ResponseEntity<Resource> getSongResource(@PathVariable String songResourceName) {
        Resource songResource = songService.loadSongAsResource(songResourceName);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(songResource);
    }



    @PostMapping("/upload")
    public ResponseEntity uploadSong(@RequestParam("songFile") MultipartFile uploadedSong){
        if(uploadedSong == null) {
            return ResponseEntity.badRequest()
                    .body("No song provided");
        }
        songService.uploadSong(uploadedSong);
        return ResponseEntity.ok("Song uploaded");
    }
}

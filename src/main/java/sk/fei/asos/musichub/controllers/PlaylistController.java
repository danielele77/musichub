package sk.fei.asos.musichub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fei.asos.musichub.models.responses.PlaylistResponse;
import sk.fei.asos.musichub.exception.ConflictException;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.Playlist;
import sk.fei.asos.musichub.models.request.PlaylistRequest;
import sk.fei.asos.musichub.services.PlaylistService;

@RestController
@RequestMapping("/playlist")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Playlist> createPlaylist(@RequestBody PlaylistRequest playlistRequest) throws ConflictException, NotFoundException {
        Playlist playlist = service.createPlaylist(playlistRequest.getUserId(), playlistRequest.getName());
        return new ResponseEntity<>(playlist, HttpStatus.CREATED);
    }

    @PostMapping("/{playlistId}")
    public ResponseEntity<Playlist> addSong(@PathVariable long playlistId, @RequestParam long songId) throws ConflictException, NotFoundException {
        Playlist playlist = service.addSong(playlistId, songId);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PostMapping("/{playlistId}/rename")
    public ResponseEntity<Playlist> renamePlaylist(@PathVariable long playlistId, @RequestParam String name) throws ConflictException, NotFoundException {
        Playlist playlist = service.rename(playlistId,name);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> infoPlaylist(@PathVariable long playlistId) throws NotFoundException {
        return new ResponseEntity<>(service.getById(playlistId), HttpStatus.OK);

    }

}

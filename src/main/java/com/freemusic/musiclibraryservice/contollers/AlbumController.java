package com.freemusic.musiclibraryservice.contollers;

import com.freemusic.musiclibraryservice.services.AlbumService;
import com.freemusic.musiclibraryservice.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/search/all")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/search")
    public Album getAlbumById(@RequestParam("albumId") int albumId) {
        return albumService.getAlbumById(albumId);
    }

    @PostMapping("/add")
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    @PostMapping("/update")
    public void updateAlbum(@RequestBody Album album) {
        albumService.updateAlbum(album);
    }

    @PostMapping("/delete")
    public void deleteAlbum(@RequestParam("albumId")int albumId) {
        albumService.deleteAlbum(albumId);
    }
}

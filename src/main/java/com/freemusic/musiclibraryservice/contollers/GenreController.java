package com.freemusic.musiclibraryservice.contollers;

import com.freemusic.musiclibraryservice.services.GenreService;
import com.freemusic.musiclibraryservice.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/search/all")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/search")
    public Genre getGenreById(@RequestParam("genreId") int genreId) {
        return genreService.getGenreById(genreId);
    }

    @PostMapping("/add")
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }

    @PostMapping("/update")
    public void updateGenre(@RequestBody Genre genre) {
        genreService.updateGenre(genre);
    }

    @PostMapping("/delete")
    public void deleteGenre(@RequestParam("genreId")int genreId) {
        genreService.deleteGenre(genreId);
    }
}

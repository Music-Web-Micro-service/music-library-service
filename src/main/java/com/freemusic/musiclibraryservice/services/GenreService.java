package com.freemusic.musiclibraryservice.services;

import com.freemusic.musiclibraryservice.models.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre getGenreById(int genreId);

    void addGenre(Genre genre);

    void updateGenre(Genre genre);

    void deleteGenre(int genreId);
}

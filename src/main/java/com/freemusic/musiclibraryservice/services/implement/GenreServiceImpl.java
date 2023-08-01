package com.freemusic.musiclibraryservice.services.implement;

import com.freemusic.musiclibraryservice.services.GenreService;
import com.freemusic.musiclibraryservice.models.Genre;
import com.freemusic.musiclibraryservice.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(int genreId) {
        return genreRepository.getReferenceById(genreId);
    }

    @Override
    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(int genreId) {
        genreRepository.deleteById(genreId);
    }
}

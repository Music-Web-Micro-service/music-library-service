package com.freemusic.musiclibraryservice.repositories;

import com.freemusic.musiclibraryservice.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}

package com.freemusic.musiclibraryservice.repositories;

import com.freemusic.musiclibraryservice.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}

package com.freemusic.musiclibraryservice.repositories;

import com.freemusic.musiclibraryservice.models.Lyric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricRepository extends JpaRepository<Lyric,Integer> {
}

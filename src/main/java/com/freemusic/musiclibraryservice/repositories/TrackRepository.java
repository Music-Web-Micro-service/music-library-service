package com.freemusic.musiclibraryservice.repositories;

import com.freemusic.musiclibraryservice.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Integer> {
}

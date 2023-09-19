package com.freemusic.musiclibraryservice.repositories;

import com.freemusic.musiclibraryservice.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,Integer> {

    List<Track> getTrackByArtistId(int artistId);
}

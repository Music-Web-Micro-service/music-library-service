package com.freemusic.musiclibraryservice.services.implement;

import com.freemusic.musiclibraryservice.services.TrackService;
import com.freemusic.musiclibraryservice.models.Track;
import com.freemusic.musiclibraryservice.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) {
        return trackRepository.findById(trackId)
                .orElse(null);
    }

    @Override
    public List<Track> getTracksByArtistId(int artistId) {
        return trackRepository.getTrackByArtistId(artistId);
    }

    @Override
    public void addTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public void updateTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public void deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
    }
}

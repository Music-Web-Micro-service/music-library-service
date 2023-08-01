package com.freemusic.musiclibraryservice.services;

import com.freemusic.musiclibraryservice.models.Track;

import java.util.List;

public interface TrackService {

    List<Track> getAllTracks();

    Track getTrackById(int trackId);

    void addTrack(Track track);

    void updateTrack(Track track);

    void deleteTrack(int trackId);
}

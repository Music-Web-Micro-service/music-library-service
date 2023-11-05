package com.freemusic.musiclibraryservice.services.implement;

import com.freemusic.feignservice.clients.UserClients;
import com.freemusic.musiclibraryservice.messages.TrackMessageToES;
import com.freemusic.musiclibraryservice.services.TrackService;
import com.freemusic.musiclibraryservice.models.Track;
import com.freemusic.musiclibraryservice.repositories.TrackRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserClients userClients;

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
        Track saveTrack = trackRepository.save(track);
        TrackMessageToES trackMessageToES = new TrackMessageToES();

        trackMessageToES.setTrackId(saveTrack.getTrackId());
        trackMessageToES.setTrackName(saveTrack.getTitle());
        trackMessageToES.setDuration(saveTrack.getDuration());

        String artistName = userClients.getArtistNameById(saveTrack.getArtistId());
        trackMessageToES.setArtistName(artistName);

        rabbitTemplate.convertAndSend("ElasticsearchExchange", "ElasticsearchRoutingKey", trackMessageToES);
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

package com.freemusic.musiclibraryservice.contollers;

import com.freemusic.musiclibraryservice.models.Album;
import com.freemusic.musiclibraryservice.models.Genre;
import com.freemusic.musiclibraryservice.models.Lyric;
import com.freemusic.musiclibraryservice.models.Track;
import com.freemusic.musiclibraryservice.repositories.AlbumRepository;
import com.freemusic.musiclibraryservice.repositories.GenreRepository;
import com.freemusic.musiclibraryservice.repositories.LyricRepository;
import com.freemusic.musiclibraryservice.repositories.TrackRepository;
import com.freemusic.musicwebcommon.messages.MusicResourceMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
public class RabbitMqListener {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private LyricRepository lyricRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private GenreRepository genreRepository;

    @RabbitListener(queues = "MusicMediaQueue")
    public void handleMessage(MusicResourceMessage message) {
        System.out.println("Received message: " + message);

        Track music = convertMessageToMusic(message);
        trackRepository.save(music);
    }

    private Track convertMessageToMusic(MusicResourceMessage message) {
        Track track = new Track();
        track.setArtistId(message.getArtistId());
        track.setTitle(message.getTitle());
        track.setBand(message.isBanned());

        track.setTitle(message.getTitle());

        track.setDuration(message.getDuration());

        track.setMusicFileId(message.getMusicResourceId());
        track.setImageId(message.getImageId());

        Integer videoId = message.getVideoId();
        if (videoId != null) {
            track.setVideoId(videoId.intValue());
        }

        if(message.getLyric() != null) {
            Lyric lyric = new Lyric();
            lyric.setLyric(message.getLyric());
            lyric.setCreatedAt(new Date());
            lyric.setUpdatedAt(new Date());
            lyric = lyricRepository.save(lyric);
            track.setLyric(lyric);
        }

        Integer albumId = message.getAlbumId();
        if(albumId != null){
            Album album = albumRepository.getReferenceById(message.getAlbumId());
            if(track.getAlbums() == null) {
                track.setAlbums(new HashSet<>());
            }
            track.getAlbums().add(album);
        }

        if(message.getGenreIds() != null) {
            List<Genre> genres = genreRepository.findAllById(message.getGenreIds());
            if(genres == null) {
                track.setGenres(new HashSet<>());
            }
            track.setGenres(new HashSet<>(genres));
        }

        track.setCreatedAt(new Date());
        track.setUpdatedAt(new Date());
        return track;
    }
}

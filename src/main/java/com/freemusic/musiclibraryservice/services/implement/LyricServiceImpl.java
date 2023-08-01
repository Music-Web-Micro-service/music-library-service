package com.freemusic.musiclibraryservice.services.implement;

import com.freemusic.musiclibraryservice.services.LyricService;
import com.freemusic.musiclibraryservice.models.Lyric;
import com.freemusic.musiclibraryservice.repositories.LyricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LyricServiceImpl implements LyricService {

    @Autowired
    private LyricRepository lyricRepository;

    @Override
    public List<Lyric> getAllLyrics() {
        return lyricRepository.findAll();
    }

    @Override
    public Lyric getLyricById(int lyricId) {
        return lyricRepository.getReferenceById(lyricId);
    }

    @Override
    public void addLyric(Lyric lyric) {
        lyricRepository.save(lyric);
    }

    @Override
    public void updateLyric(Lyric lyric) {
        lyricRepository.save(lyric);
    }

    @Override
    public void deleteLyric(int lyricId) {
        lyricRepository.deleteById(lyricId);
    }
}

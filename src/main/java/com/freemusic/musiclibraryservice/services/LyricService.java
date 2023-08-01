package com.freemusic.musiclibraryservice.services;

import com.freemusic.musiclibraryservice.models.Lyric;

import java.util.List;

public interface LyricService {

    List<Lyric> getAllLyrics();

    Lyric getLyricById(int lyricId);

    void addLyric(Lyric lyric);

    void updateLyric(Lyric lyric);

    void deleteLyric(int lyricId);
}

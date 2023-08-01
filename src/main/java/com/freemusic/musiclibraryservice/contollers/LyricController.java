package com.freemusic.musiclibraryservice.contollers;

import com.freemusic.musiclibraryservice.services.LyricService;
import com.freemusic.musiclibraryservice.models.Lyric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lyric")
public class LyricController {

    @Autowired
    private LyricService lyricService;

    @GetMapping("/search/all")
    public List<Lyric> getAllLyrics() {
        return lyricService.getAllLyrics();
    }

    @GetMapping("/search")
    public Lyric getLyricById(@RequestParam("lyricId") int lyricId) {
        return lyricService.getLyricById(lyricId);
    }

    @PostMapping("/add")
    public void addLyric(@RequestBody Lyric lyric) {
        lyricService.addLyric(lyric);
    }

    @PostMapping("/update")
    public void updateLyric(@RequestBody Lyric lyric) {
        lyricService.updateLyric(lyric);
    }

    @PostMapping("/delete")
    public void deleteLyric(@RequestParam("lyricId")int lyricId) {
        lyricService.deleteLyric(lyricId);
    }
}

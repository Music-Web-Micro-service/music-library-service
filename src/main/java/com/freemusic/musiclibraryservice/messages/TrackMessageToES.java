package com.freemusic.musiclibraryservice.messages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackMessageToES {
    private int trackId;
    private String trackName;
    private String artistName;
    private Double duration;
}

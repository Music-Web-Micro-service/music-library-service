package com.freemusic.musiclibraryservice.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class AlbumMessageToES {
    private int albumId;

    private Integer imageId;

    private Date releaseDate;

    private String artistName;

    private String title;
}

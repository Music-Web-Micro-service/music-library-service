package com.freemusic.musiclibraryservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracks")
public class Track implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackId;

    @OneToOne
    @JoinColumn(name = "lyric_id")
    private Lyric lyric;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "trackGenre",
            joinColumns = @JoinColumn(name = "trackId"),
            inverseJoinColumns = @JoinColumn(name = "genreId")
    )
    private Set<Genre> genres;

    @JsonIgnore
    @ManyToMany(mappedBy = "tracks")
    private Set<Album> albums;

    private String title;
    private boolean isBand = false;
    private int artistId;
    private double duration;
    private int imageId;
    private int videoId;
    private int musicFileId;
    private TrackStatus trackStatus;
    private Date createdAt;
    private Date updatedAt;

}

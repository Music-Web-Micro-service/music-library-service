package com.freemusic.musiclibraryservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "albumTrack",
            joinColumns = @JoinColumn(name = "albumId"),
            inverseJoinColumns = @JoinColumn(name = "trackId")
    )
    private Set<Track> tracks;

    private String title;

    private boolean isBand = false;
    private int artistId;

    private String imageId;

    private Date releaseDate;

    private Date createdAt;

    private Date updatedAt;
}

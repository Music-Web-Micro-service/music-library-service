package com.freemusic.musiclibraryservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="lyrics")
public class Lyric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lyricId;

    @JsonIgnore
    @OneToOne(mappedBy = "lyric")
    private Track track;

    private String lyric;

    private Date createdAt;

    private Date updatedAt;
}

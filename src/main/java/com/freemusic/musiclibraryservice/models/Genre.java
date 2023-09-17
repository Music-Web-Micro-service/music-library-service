package com.freemusic.musiclibraryservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Track> tracks;

    private String name;

    private Date created_at;

    private Date updated_at;
}

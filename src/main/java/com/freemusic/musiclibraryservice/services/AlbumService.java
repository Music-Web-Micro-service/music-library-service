package com.freemusic.musiclibraryservice.services;

import com.freemusic.musiclibraryservice.models.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums();

    Album getAlbumById(int albumId);

    void addAlbum(Album album);

    void updateAlbum(Album album);

    void deleteAlbum(int albumId);
}

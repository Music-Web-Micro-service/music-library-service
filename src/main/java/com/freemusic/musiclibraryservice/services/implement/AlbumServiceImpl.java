package com.freemusic.musiclibraryservice.services.implement;

import com.freemusic.musiclibraryservice.services.AlbumService;
import com.freemusic.musiclibraryservice.models.Album;
import com.freemusic.musiclibraryservice.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(int albumId) {
        return albumRepository.getReferenceById(albumId);
    }

    @Override
    public void addAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(int albumId) {
        albumRepository.deleteById(albumId);
    }
}

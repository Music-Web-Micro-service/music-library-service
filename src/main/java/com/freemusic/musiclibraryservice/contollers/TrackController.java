package com.freemusic.musiclibraryservice.contollers;

import com.freemusic.musiclibraryservice.services.TrackService;
import com.freemusic.musiclibraryservice.models.Track;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

   // private final String[] fileTypes = new String[]{"music","video","image"};

    @GetMapping("/search/all")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @Transactional
    @GetMapping("/search")
    public ResponseEntity<Track> getTrackById(@RequestParam("trackId") int trackId) {
        Track track = trackService.getTrackById(trackId);
        if(track != null){
            return  new ResponseEntity<>(track, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/artist")
    public ResponseEntity<List<Track>> getTracksByArtistId(@RequestParam("artistId") int artistId){
        List<Track> result = trackService.getTracksByArtistId(artistId);
        if(result != null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //need to change
   /* @PostMapping("/add")
    public void addTrack(@RequestParam("track") String trackStr, @RequestParam("files") MultipartFile[] files) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Track track = objectMapper.readValue(trackStr, Track.class);
        // Save track to DB
        trackService.addTrack(track);

        // Process each file
        // in here one track should have only one music, image and video
        int index = 0;
        for (MultipartFile file : files) {
            //TODO have to fix it
            //check file type to do
            // MusicMessage message = new MusicMessage(track.getMediaId(), track.getTitle(), fileTypes[index++], file.getContentType());
            // message.setFile(file);
            // rabbitTemplate.convertAndSend("MusicExchanges", "MusicMedia", message);
        }
    }*/

    @PostMapping("/update")
    public void updateTrack(@RequestBody Track track) {
        trackService.updateTrack(track);
    }

    @PostMapping("/delete")
    public void deleteTrack(@RequestParam("trackId")int trackId) {
        trackService.deleteTrack(trackId);
    }

}

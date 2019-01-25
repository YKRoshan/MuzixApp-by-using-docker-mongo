package com.stackroute.controller;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.MusicNotFoundException;
import com.stackroute.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MusicController {
    MusicService musicService;
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public void music(){
//
//    }

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("music")
    //@RequestMapping (path = "/something", method = RequestMethod.PUT)
    public ResponseEntity<?> savedMusic(@RequestBody Music music){
         ResponseEntity responseEntity;
         try {
             musicService.saveMusic(music);
             responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

         }catch (MusicAlreadyExistsException e){
             responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);

         }
         return responseEntity;
    }
    @GetMapping("music")
    public ResponseEntity<?> getAllMusic(){

        return new ResponseEntity<>(musicService.getAllMusic(),HttpStatus.OK);
    }

    @DeleteMapping("/DeleteTrack")
   public void deleteTrack(@RequestParam String id) throws MusicNotFoundException{
        try {
            musicService.deleteByTrackId(id);
        } catch (MusicNotFoundException e) {
            throw new MusicNotFoundException("Music not found");
        }
    }

    @PutMapping("update")
    //@RequestMapping (path = "/something", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMusic(@RequestBody Music music){
        ResponseEntity responseEntity;
        try {
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        }catch (MusicAlreadyExistsException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByTrackName(@RequestParam String name ){
        return new ResponseEntity<List<Music>>(musicService.findByTrackName(name),HttpStatus.OK);
    }

}

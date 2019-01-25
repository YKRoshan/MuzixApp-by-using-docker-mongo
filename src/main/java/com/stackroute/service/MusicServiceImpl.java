package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.MusicNotFoundException;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistsException {
        if(musicRepository.existsById(music.getTrackId())){
            throw new MusicAlreadyExistsException("Music already exits");
        }
        Music savedMusic = musicRepository.save(music);
        if(savedMusic==null){
            throw new MusicAlreadyExistsException("Music already exits");
        }
        return savedMusic;
    }

    @Override
    public List<Music> getAllMusic() {

        return musicRepository.findAll();
    }

    @Override
    public void deleteMusic(Music music) throws MusicAlreadyExistsException {

        if(!musicRepository.existsById(music.getTrackId())){
            throw new MusicAlreadyExistsException("Music already exits");
        }
        musicRepository.delete(music);

    }

    @Override
    public void deleteByTrackId(String id) throws MusicNotFoundException {
        int temp = new Integer(id);
        if(!musicRepository.existsById(temp)){
            throw new MusicNotFoundException("Music not found");
        }
        musicRepository.deleteById(temp);
    }

    @Override
    public Music updateMusic(Music music) throws MusicAlreadyExistsException {
        if(musicRepository.existsById(music.getTrackId())){
            throw new MusicAlreadyExistsException("Music already exits");
        }
        Music savedMusic = musicRepository.save(music);
        if(savedMusic==null){
            throw new MusicAlreadyExistsException("Music already exits");
        }
        return savedMusic;
    }

    @Override
    public List<Music> findByTrackName(String searchTerm) {
        List<Music> savedMusic = musicRepository.findByTrackName(searchTerm);
        return savedMusic;
    }
}

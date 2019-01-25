package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.MusicNotFoundException;
/*Music service interface*/

import java.util.List;

public interface MusicService {
    public Music saveMusic(Music music) throws MusicAlreadyExistsException;
    public List<Music> getAllMusic();
    public void deleteMusic(Music music) throws MusicAlreadyExistsException;
    public void deleteByTrackId(String id) throws MusicNotFoundException;
    public Music updateMusic(Music music) throws MusicAlreadyExistsException;
    public List<Music> findByTrackName(String name);

}

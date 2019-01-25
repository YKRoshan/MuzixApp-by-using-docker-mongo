package com.stackroute.repository;


import com.stackroute.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music, Integer> {

   // @Query("SELECT m FROM Music m WHERE m.trackName =?1")
    public List<Music> findByTrackName(String name);
}

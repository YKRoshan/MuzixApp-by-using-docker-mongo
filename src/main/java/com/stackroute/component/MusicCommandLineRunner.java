
/*Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
information whenever the application starts. Use both approaches:
Approach 1: ApplicationListener<ContextRefreshedEvent>
Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)*/
package com.stackroute.component;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MusicCommandLineRunner implements CommandLineRunner {

    private MusicService musicService;

    @Autowired
    public MusicCommandLineRunner(MusicService musicService) {
        this.musicService = musicService;
    }
    @Override
    public void run(String... args) throws Exception {
        Music music = new Music(2,"AppC","ffrg");
        try {
            musicService.saveMusic(music);
        } catch (MusicAlreadyExistsException e) {
//            throw new MusicAlreadyExistsException("Music Already Exists");
        }

    }
}

///*Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
//information whenever the application starts. Use both approaches:
//Approach 1: ApplicationListener<ContextRefreshedEvent>
//Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)*/
//package com.stackroute.component;
//
//import com.stackroute.domain.Music;
//import com.stackroute.exceptions.MusicAlreadyExistsException;
//import com.stackroute.service.MusicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MusicComponent implements ApplicationListener{
//
//    private MusicService musicService;
//
//    @Autowired
//    public MusicComponent(MusicService musicService) {
//        this.musicService = musicService;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        Music music = new Music(1,"AppL","ddsgf");
//        try {
//            musicService.saveMusic(music);
//        } catch (MusicAlreadyExistsException e) {
////            throw new MusicAlreadyExistsException("Music Already Exists");
//        }
//    }
//}
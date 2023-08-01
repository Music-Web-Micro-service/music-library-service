package com.freemusic.musiclibraryservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MusicLibraryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicLibraryServiceApplication.class, args);
    }

}

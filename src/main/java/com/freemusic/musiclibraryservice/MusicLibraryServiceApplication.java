package com.freemusic.musiclibraryservice;


import com.freemusic.feignservice.clients.UserClients;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@SpringBootApplication
@EnableFeignClients(clients = {UserClients.class})
public class MusicLibraryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicLibraryServiceApplication.class, args);
    }

}

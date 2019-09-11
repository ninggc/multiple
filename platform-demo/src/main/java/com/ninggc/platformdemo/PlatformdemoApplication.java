package com.ninggc.platformdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PlatformdemoApplication {

    @Bean("myThreadPool")
    public ExecutorService myThreadPool() {
        return Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        SpringApplication.run(PlatformdemoApplication.class, args);
    }

}

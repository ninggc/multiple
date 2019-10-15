package com.ninggc.springconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigDemoApplication.class, args);
    }

}

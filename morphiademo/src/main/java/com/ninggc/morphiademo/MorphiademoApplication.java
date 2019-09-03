package com.ninggc.morphiademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
@RestController
public class MorphiademoApplication {

    @GetMapping("app")
    public String app() {
        return "app";
    }

    public static void main(String[] args) {
        SpringApplication.run(MorphiademoApplication.class, args);
    }
}

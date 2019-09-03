package com.ninggc.morphiademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
@RestController
public class MorphiademoApplication {

    @GetMapping("")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ninggc");
        map.put("project", "spring boot demo");
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(MorphiademoApplication.class, args);
    }
}

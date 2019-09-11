package com.ninggc.demo.morphiademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
@PropertySource("classpath:morphia/morphia.properties")
@RestController
public class MorphiademoApplication {
    private final Environment environment;

    public MorphiademoApplication(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ninggc");
        map.put("project", "MorphiademoApplication");
        return map;
    }

    @GetMapping("/env")
    public String[] env() {
        return environment.getActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(MorphiademoApplication.class, args);
    }
}

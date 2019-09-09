package com.ninggc.messagequeuedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class MessagequeuedemoApplication {

    @GetMapping("")
    public Map<String, Object> app() {
        Map<String, Object> map = new HashMap<>();
        map.putIfAbsent("name", "MessagequeuedemoApplication");
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagequeuedemoApplication.class, args);
    }

}

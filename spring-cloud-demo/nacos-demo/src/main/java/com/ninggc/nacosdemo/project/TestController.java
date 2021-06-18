package com.ninggc.nacosdemo.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestMapping("/test")
@RestController
public class TestController {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(LocalDateTime.now());
    }

    @GetMapping
    public void String() {
        LocalDate localDate = LocalDate.now();
        localDate.toString();
    }
}

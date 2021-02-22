package com.ninggc.nacosdemo.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping
    public void String() {
        return String.valueOf(new LocalDate());
    }
}

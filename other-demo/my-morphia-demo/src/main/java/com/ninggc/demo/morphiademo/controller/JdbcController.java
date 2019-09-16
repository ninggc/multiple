package com.ninggc.demo.morphiademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public boolean test() {
        return jdbcTemplate == null;
    }
}

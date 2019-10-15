package com.ninggc.demo.web;

import com.ninggc.demo.aspect.Audience;
import com.ninggc.demo.aspect.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perform")
public class PerformerController {

    @Autowired
    Performance performance;

    @Autowired
    Audience audience;

    @GetMapping("")
    public void perform() {
        performance.perform("qwe", 123L);
//        audience.performance();
    }
}

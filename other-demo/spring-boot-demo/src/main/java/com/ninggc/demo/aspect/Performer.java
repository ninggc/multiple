package com.ninggc.demo.aspect;

import org.springframework.stereotype.Component;

@Component
public class Performer implements Performance {

    @Override
    public void perform(String s, Long l) {
        System.out.println("perform " + s + " " + l);
    }
}

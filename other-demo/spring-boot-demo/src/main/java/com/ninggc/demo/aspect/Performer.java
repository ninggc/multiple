package com.ninggc.demo.aspect;

import org.springframework.stereotype.Component;

@Component
public class Performer implements Performance {
    @Override
    public void perform() {
        System.out.println("perform");
    }
}

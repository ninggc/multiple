package com.ninggc.demo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
    @Pointcut
    public void performance() {

    }

    @Before("execution(* com.ninggc.demo.aspect.Performer.perform(..))")
    public void before() {
        System.out.println("before");
    }
    @AfterReturning("execution(* com.ninggc.demo.aspect.Performance.perform(..))")
    public void afterReturning() {
        System.out.println("return");
    }
    @AfterThrowing("execution(* com.ninggc.demo.aspect.Performance.perform(..))")
    public void afterThrowing() {
        System.out.println("throw");
    }
}

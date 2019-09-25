package com.ninggc.learning.project.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/*
 * @description
 * @author Ninggc
 * @create 2019-09-25 09:44
 */
@Component
@DependsOn(value = {"bean1"})
@Qualifier("second")
public class Bean2 {
    public Bean2() {
        System.out.println("bean2 init");
    }
}

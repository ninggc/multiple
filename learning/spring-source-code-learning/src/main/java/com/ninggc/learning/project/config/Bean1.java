package com.ninggc.learning.project.config;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @description
 * @author Ninggc
 * @create 2019-09-25 09:44
 */
@Component
@Qualifier("first")
public class Bean1 implements InitializingBean, BeanNameAware {
    public Bean1() {
        System.out.println("bean1 init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName --> " + name);
    }
}

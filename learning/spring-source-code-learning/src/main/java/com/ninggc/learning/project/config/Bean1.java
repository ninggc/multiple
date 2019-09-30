package com.ninggc.learning.project.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
 * @description
 * @author Ninggc
 * @create 2019-09-25 09:44
 */
@Component
@Qualifier("first")
@DependsOn(value = {"bean2"})
public class Bean1 implements ApplicationContextAware, InitializingBean, BeanNameAware, BeanPostProcessor, DisposableBean {
    public Bean1() {
        System.out.println("Bean1.Bean1");
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean1.init");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Bean1.preDestroy");
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        System.out.println("Bean1.setApplicationContext");
    }

    @Override
    public void setBeanName(@NonNull String name) {
        System.out.print("Bean1.setBeanName\t");
        System.out.println("name = " + name);
    }

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, String beanName) throws BeansException {
        System.out.println("Bean1.postProcessBeforeInitialization");
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Bean1.afterPropertiesSet");
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, String beanName) throws BeansException {
        System.out.println("Bean1.postProcessAfterInitialization");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Bean1.destroy");
    }
}

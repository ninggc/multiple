package com.ninggc.springmvc.sample.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;

//@Configuration
public class TestBean implements InitializingBean, DisposableBean, ApplicationContextAware, BeanPostProcessor {
    final static Logger logger = LoggerFactory.getLogger(TestBean.class);

    String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @PostConstruct
    public void postConstruct() {
        logger.info(getCurrentMethodName());
    }

    @PreDestroy
    public void preDestory() {
        logger.info(getCurrentMethodName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info(getCurrentMethodName());
    }

    @Override
    public void destroy() throws Exception {
        logger.info(getCurrentMethodName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info(getCurrentMethodName());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info(getCurrentMethodName());
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info(getCurrentMethodName());
        return null;
    }
}

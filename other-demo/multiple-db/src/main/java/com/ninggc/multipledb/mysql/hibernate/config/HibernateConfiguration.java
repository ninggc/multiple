package com.ninggc.multipledb.mysql.hibernate.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ninggc.multipledb.mysql.hibernate.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Ninggc
 * @create 2019-10-14 10:34
 * @description nothing
 */
@Configuration
@EnableConfigurationProperties(HibernateProperties.class)
public class HibernateConfiguration {
    @Autowired
    HibernateProperties properties;

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(comboPooledDataSource());
        sessionFactoryBean.setPackagesToScan("com.ninggc.multipledb.mysql.hibernate.entity");

        sessionFactoryBean.setAnnotatedClasses(QuestionEntity.class);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }

    @Bean
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUser(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }
}

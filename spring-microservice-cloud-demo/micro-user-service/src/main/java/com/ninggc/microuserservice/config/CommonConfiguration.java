package com.ninggc.microuserservice.config;

import com.google.gson.Gson;
import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.util.autogenerate.AutoGeneration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfiguration implements WebMvcConfigurer {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    @Scope("prototype")
    public UserEntity user() {
        return AutoGeneration.genInstance(UserEntity.class);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yy-MM-dd HH:mm:ss"));
    }
}

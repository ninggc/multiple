package com.ninggc.microuserservice.config;

import com.google.gson.Gson;
import com.ninggc.util.autogenerate.AutoGeneration;
import com.ninggc.util.autogenerate.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CommonConfiguration {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    @Scope("prototype")
    public UserEntity user() {
        return AutoGeneration.genInstance(UserEntity.class);
    }
}

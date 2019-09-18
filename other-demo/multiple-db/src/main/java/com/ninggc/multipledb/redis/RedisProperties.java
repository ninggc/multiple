package com.ninggc.multipledb.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    @NotBlank
    private String host;
    @Min(0) @Max(65535)
    private Integer port;
    @Min(0)
    private Integer database;
    @Nullable
    private String password;
    @Nullable
    private String uri;
    @Nullable
    private String timeout;
}

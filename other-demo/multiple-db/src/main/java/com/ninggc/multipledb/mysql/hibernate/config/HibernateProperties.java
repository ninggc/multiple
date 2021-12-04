package com.ninggc.multipledb.mysql.hibernate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ninggc
 * @create 2019-10-14 10:34
 * @description nothing
 */
@Data
@ConfigurationProperties(prefix = "spring.mysql")
public class HibernateProperties {
    public String ip;
    public String port;
    public String schema;
    public String username;
    public String password;
    public String url;
}

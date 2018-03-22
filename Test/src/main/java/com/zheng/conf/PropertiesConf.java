package com.zheng.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by lenovo on 2018/3/20.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class PropertiesConf {
    @Value("${spring.jdbc.username}")
    private String username;
    @Value("${spring.jdbc.url}")
    private String url;
    @Value("${spring.jdbc.driver}")
    private String driver;
    @Value("${spring.jdbc.password}")
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();

    }
}

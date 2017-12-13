package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by chenyunan on 2017/12/13.
 */
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SpringSessionRedisDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionRedisDemoApp.class, args);
    }

}

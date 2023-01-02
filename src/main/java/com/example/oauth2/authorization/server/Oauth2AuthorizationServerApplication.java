package com.example.oauth2.authorization.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan("com.example.oauth2.authorization.server.mapper")
@SpringBootApplication
public class Oauth2AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizationServerApplication.class, args);
    }

}

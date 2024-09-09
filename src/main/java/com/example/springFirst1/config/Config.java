package com.example.springFirst1.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// configuration annotation is used to mark a class as a configuration class and initialize the spring application context.
@Configuration
public class Config {

    //when third party the we have store it in the bean and we can use it in the controller
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
    
}

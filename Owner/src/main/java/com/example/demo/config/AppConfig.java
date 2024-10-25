package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/*Author: Sanket Nadargi*/

@Configuration
public class AppConfig {
	// The `@Bean` annotation is used to indicate it shall be managed by the Spring container.
    @Bean
    //This method is  be used for making REST API calls
    public RestTemplate restTemplate() {
    	// Creates and returns a new `RestTemplate` object.
        return new RestTemplate();
    }
}

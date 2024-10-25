package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*Author: Sanket Nadargi*/

//To enable Eureka Server.
//This  marks this class as a Spring Boot application. 
@EnableEurekaServer
@SpringBootApplication
public class AppServerApplication {

	public static void main(String[] args) {
		// The run() method starts the Spring Boot application and initializing the Eureka' server.
		SpringApplication.run(AppServerApplication.class, args);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
/*Author: Sanket Nadargi*/


@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Owner API", version="2.0",description="CRUD api for Owner"))
//Defines the OpenAPI (Swagger) documentation for this application, giving it a title, version, and description for the Owner API.

public class OwnerApplication {
	// The main method serves as the entry point for the Java application.

	public static void main(String[] args) {
		SpringApplication.run(OwnerApplication.class, args);
	}
	
}

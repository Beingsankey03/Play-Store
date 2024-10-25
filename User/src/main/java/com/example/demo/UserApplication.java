package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
/*Author: Sanket Nadargi*/
@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="User API", version="1.0",description="CRUD operations for User"))
//Defines the OpenAPI (Swagger) documentation for this application, giving it a title, version, and description for the Owner API.

public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	

}

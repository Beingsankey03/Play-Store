package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*Author: Sanket Nadargi*/

public class ServletInitializer extends SpringBootServletInitializer {
	// This class is used when deploying the Spring Boot application to a traditional web container Tomcat.

	@Override
	// Overrides a method from the parent class `SpringBootServletInitializer`.
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppServerApplication.class);
	}

}

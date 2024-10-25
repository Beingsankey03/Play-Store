package com.notification;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*Author: Sanket Nadargi*/

public class ServletInitializer extends SpringBootServletInitializer {
    // Overriding the configure method to specify the application source
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NotificationServiceApplication.class);
	}

}

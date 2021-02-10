package com.myRetailService.poc.service.initializer;

import com.myRetailService.poc.service.initializer.MyRetailServiceApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyRetailServiceApplication.class);
	}

}

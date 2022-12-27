package com.aiokLeo.demoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoBootApplication.class, args);

		AccountDetails Person = context.getBean(AccountDetails.class);
		Person.show();
	}

}

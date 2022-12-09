package com.aiokLeo.demoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoBootApplication.class, args);

//		AccountDetails Person = context.getBean(AccountDetails.class);             // Find The Bean Object
                                                                                   // And Person Object

//		Person.setAccountId("002");
//		Person.setName("AiokLeo");
//		Person.setAddress("83 Sadek Khan Read, Dhaka-1207");
//		Person.DisplayDetails();
	}

}

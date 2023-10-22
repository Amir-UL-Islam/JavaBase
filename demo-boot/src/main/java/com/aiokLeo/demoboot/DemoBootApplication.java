package com.aiokLeo.demoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoBootApplication {
//	Starting From Here
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoBootApplication.class, args);

		// I don't Need to Instantiate the Object
		// Everytime I will call .getBean()
		// Spring will dose for Me.
		// Spring will look for @Component Annotation
		// And Automatically Create Object for Me
		// All I have to Care about Logic.
		AccountDetails Person = context.getBean(AccountDetails.class);

		// Like Here
		// The Object Person is Automatically Created for me.
		// And The Singleton Constructor Will be automatically Called Even if I don't Call.
		// In This case the AccountDetails() Constructor is Automatically Called.

		// show() is Prototype Method by Default.
		// Which is Why it will be Executed When it Called.
		Person.show();

		// If I want all The Object to Prototype
		// I have to Annotate @Scan(value="prototype")


	}

}

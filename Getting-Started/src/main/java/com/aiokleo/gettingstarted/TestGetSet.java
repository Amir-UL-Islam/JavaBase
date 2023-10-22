package com.aiokleo.gettingstarted;

//For IOC Implementation
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestGetSet {
	public static void main(String[] args) {
		
//		IOC Implementation an (XML based Approach)
//		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
																			// It's an Interface Always Refer to /src/main/resource *.xml file
																			// This configuration Expect some Configuration File
																			// XML Based File
																			// We need to Create
																			// The AccountDetails.java File is a Normal Java Class
																			// We need to Convert That file to Container Level Component
																			// To Create The Object Details for AccountDetails.java File
																			// We need to Create a XML file Called ApplicationContext.xml
																			// Which Will allow us to Configure the AccountDetails.java File's Configuration
		
		
//		Here AccountDetails is a Spring Component
		AccountDetails Person = (AccountDetails)context.getBean("PersonWillUsedInTestGetSet"); // Find The Bean Object
																							    	// And Person Object
		Person.setAccountId("002");
		Person.setName("AiokLeo");
		Person.setAddress("83 Sadek Khan Read, Dhaka-1207");
		
		Person.DisplayDetails();
		
//		((ClassPathXmlApplicationContext) context).close(); // Closing The Context
		
//		Normal Implementation
//		AccountDetails person = new AccountDetails();
//		person.setAccountId("001");
//		person.setName("Amir");
//		person.setAddress("83 Sadek Khan Read, Dhaka-1207");
//		
//		person.DisplayDetails();
		
	}
}

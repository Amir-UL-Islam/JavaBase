package com.aiokleo.gettingstarted;

//For IOC Implementation
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestGetSet {
	public static void main(String[] args) {
		
//		IOC Implementation an (XML based Approach)
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext(CustomerBeanConfig.class);

		ApplicationContext context = new AnnotationConfigApplicationContext(CustomerBeanConfig.class);
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
		AccountDetails Person = (AccountDetails)context.getBean("accountDetails"); // Find The Bean Object
																						 // And Person Object
		Person.setAccountId("002");
		Person.setName("AiokLeo");
		Person.setAddress("83 Sadek Khan Read, Dhaka-1207");
		
		Person.DisplayDetails();
		
//		((ClassPathXmlApplicationContext) context).close(); // Closing The Context [In Eclipse it's OKey]
															// BUT in Intellij it Throws Error

//		Exception in thread "main" java.lang.ClassCastException: class org.springframework.context.annotation.AnnotationConfigApplicationContext cannot be cast to class org.springframework.context.support.ClassPathXmlApplicationContext (org.springframework.context.annotation.AnnotationConfigApplicationContext and org.springframework.context.support.ClassPathXmlApplicationContext are in unnamed module of loader 'app')
//	at com.aiokleo.gettingstarted.TestGetSet.main(TestGetSet.java:37)





//		Normal Implementation // Will became Redundant In the Case of Big Project
		// So we will go with the above process by automating the Object Creation.


//		AccountDetails person = new AccountDetails();
//		person.setAccountId("001");
//		person.setName("Amir");
//		person.setAddress("83 Sadek Khan Read, Dhaka-1207");
//		
//		person.DisplayDetails();
		
	}
}

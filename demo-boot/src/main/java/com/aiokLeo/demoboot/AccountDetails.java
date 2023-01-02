package com.aiokLeo.demoboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aiokLeo.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Getter
@Setter
@AllArgsConstructor
@Component // By Adding this Annotation
			// I am telling Spring, this is a Class I want Object of.
//@Scope(value = "prototype") // By Default the Constructor AccountDetails() is Singleton
							// If I want to be all method and Constructors to Prototype
							// I have to Specify with this Annotation.
							// Now I can call theAccountDetails() as many as I want

@ComponentScan(basePackages = {"com.aiokLoe.demoboot", "org.aiokLeo.Address"}) // If we DON'T ADD ComponentScan Again The org.aiokLeo.Address will NOT be Included
public class AccountDetails {
	private int id;
	private String employeeName;

	@Autowired // AKA the Dependency Injection.
	private Address address;
	//	AccountDetails Constructor For Verifying the Location of the FILE
	public AccountDetails(){
		System.out.println("AccountDetails is Rolling");
	}

	public void show(){
		System.out.println("AccountDetails.java File responding with Method.");
		address.Compile();
	}
}

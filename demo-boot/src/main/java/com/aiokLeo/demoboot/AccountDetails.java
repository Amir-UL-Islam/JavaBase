package com.aiokLeo.demoboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Getter
@Setter
@AllArgsConstructor
@Component

//If we DON'T ADD ComponentScan Again The org.aiokLeo.Address will NOT be Included
@ComponentScan(basePackages = {"com.aiokLoe.demoboot", "org.aiokLeo.Address"})
public class AccountDetails {
	private String accountId;
	private String name;
	private String address;
	
	//	AccountDetails Constructor For Verifying the Location of the FILE
	public AccountDetails(){
		System.out.println("AccountDetails is Rolling");
	}

	public void show(){
		System.out.println("AccountDetails.java File responding.");
	}
}

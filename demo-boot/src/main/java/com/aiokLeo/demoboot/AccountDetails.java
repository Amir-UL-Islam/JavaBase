package com.aiokLeo.demoboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component // Component Scanning is available in Base Package FROM com.aiokLeo.demoboot > subPackage > ... if any

//If we DON'T ADD ComponentScan Again The org.aiokLeo.Address will NOT be Included
@ComponentScan(basePackages = {"com.aiokLoe.demoboot", "org.aiokLeo.Address"})
public class AccountDetails {
	private String accountId;
	private String name;
	private String address;
	
//	To Generate Constructors go to Source

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void DisplayDetails() {
		System.out.println("AccountId:" + accountId + " Name: " +  name + " Address: " + address);
	}



	//	AccountDetails Constructor For Verifying the Location of the FILE
	public  AccountDetails(){
		System.out.println("AccountDetails is Rolling");
	}
}

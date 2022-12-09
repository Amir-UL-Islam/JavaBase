package com.aiokleo.gettingstarted;

import org.springframework.stereotype.Component;

@Component // This will create OBJECT Runtime and We can change the Default Reference "accountDetails" to anything
			// and add that to @Component("example") LIKE THIS
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
	
	
}

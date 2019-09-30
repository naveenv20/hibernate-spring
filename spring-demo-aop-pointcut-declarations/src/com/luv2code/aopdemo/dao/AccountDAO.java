package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK : ADDING AN ACCOUNT");
	}



	public String getName() {
		System.out.println(getClass() + ": getname");
	
		return name;
	}



	public void setName(String name) {
		System.out.println(getClass() + ": setname");
		
		this.name = name;
	}



	public String getServiceCode() {
		System.out.println(getClass() + ": getcode");
		
		return serviceCode;
	}



	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setcode");
		
		this.serviceCode = serviceCode;
	}
	
	

}

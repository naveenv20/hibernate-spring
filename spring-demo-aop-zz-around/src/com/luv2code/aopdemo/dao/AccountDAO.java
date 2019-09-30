package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> findAccounts(boolean tripwire){
		
		
		if(tripwire==true){
			throw new RuntimeException("no soup for you!!!!");
		}
		
		List<Account> myAccounts=new ArrayList<>();
		
		//create sample accounts
		Account temp1= new Account("John","Silver");
		Account temp2= new Account("Smith","Platinmum");
		Account temp3= new Account("Claire","Gold");
		
		//add them  to our accounts
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		
		return myAccounts;
	}

}

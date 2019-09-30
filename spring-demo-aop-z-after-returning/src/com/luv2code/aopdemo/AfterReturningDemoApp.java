package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean fro the spring container
			
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		//cal methods to find accounts
		
		List<Account> tempAccount=theAccountDAO.findAccounts();
		
		
		//display account
		System.out.println("\n Main prog after retrning the find accounts");
		
		System.out.println("--------");
		
		System.out.println(tempAccount);
		System.out.println("\n");
		
		//close the context
		context.close();
		
		
		
		
		
		
		
	}

}

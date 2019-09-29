package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean fro the spring container
		
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		//call the business method
		theAccountDAO.addAccount();

		
		//close the context
		context.close();
		
		
		
		
		
		
		
	}

}

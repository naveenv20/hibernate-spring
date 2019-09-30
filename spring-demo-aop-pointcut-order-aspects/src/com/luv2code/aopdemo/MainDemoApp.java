package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean fro the spring container
			
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		//get the membership bean
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
		//call the business method
		Account account=new Account();
		theAccountDAO.setName("Sai");
		theAccountDAO.setServiceCode("ram");
		System.out.println(theAccountDAO.getName());
		System.out.println(theAccountDAO.getServiceCode());
		theAccountDAO.addAccount(account,true);

		
		//close the context
		context.close();
		
		
		
		
		
		
		
	}

}

package com.luv2code.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemo {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean fro the spring container
			
		TrafficFortuneService theTrafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		System.out.println("\n main program AroundDemoAPP");
		
		System.out.println("\n calling getfortune");
		
		String data=theTrafficFortuneService.getFortune();
		
		boolean tripwire=true;
		
		
		String data1=theTrafficFortuneService.getFortune2(tripwire);
		
		
		//close the context
		context.close();
		
		
		System.out.println("My Fortune is :"+data );
	
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!");
		
		System.out.println("My Fortune is :"+data1 );
		System.out.println("Finished!!!!!!!!!");
		
		
	}

}

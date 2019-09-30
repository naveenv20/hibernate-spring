package com.luv2code.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import com.sun.istack.internal.logging.Logger;

public class AroundDemoWithLoggerDemoAPP {
	
	private static Logger myLogger=Logger.getLogger(AroundDemoWithLoggerDemoAPP.class);
	

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean fro the spring container
			
		TrafficFortuneService theTrafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		
		myLogger.info("\n main program AroundDemoAPP");
		
		myLogger.info("\n calling getfortune");
		
		
		
		String data=theTrafficFortuneService.getFortune();
		
		//close the context
		context.close();
		
		
		myLogger.info("My Fortune is :"+data );
		myLogger.info("Finished!!!!!!!!!");
		
		
		
		
		
		
	}

}

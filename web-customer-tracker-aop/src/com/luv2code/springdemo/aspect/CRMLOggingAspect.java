package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class CRMLOggingAspect {
	
	//set up logger
	private Logger mylogger= Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		 
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void fordaoPackage() {
		 
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
		 
	}
	
	@Pointcut("forControllerPackage()||fordaoPackage()||forServicePackage()")
	private void forAppflow() {
		 
	}
	
	// @BEfore advice
	
	@Before("forAppflow()")
	public void before(JoinPoint thejoinpoint) {
		//display the method name 
		
		String themethod=thejoinpoint.getSignature().toShortString();
		mylogger.info("======>>> in @Before : Calling method "+ themethod);
		
		//display the argurments
		Object args[]=thejoinpoint.getArgs();
		
		for (Object temporg:args) {
			mylogger.info("======>>>argument : "+temporg);
		}
		
	}
	

	
	
	
	
	
	//@ afterreturning advice
	@AfterReturning(
			pointcut="forAppflow()",
			returning="theresult"
			)
	public void afterreturning(JoinPoint thejoinpoint, Object theresult) {
		
			
		//display the method name 
		
				String themethod=thejoinpoint.getSignature().toShortString();
				mylogger.info("======>>> in @AfterReturning : Calling method "+ themethod);
				
		//display the data returned	
				mylogger.info("======>>> result: "+theresult);	
				
				
	}
	

}

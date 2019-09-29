package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	//this is where we add all our related advices for logging 
	
	//lets start with an @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccontAdvice() {
		
		System.out.println("\n ============>>>>> Before advise on the addAccount ()");
	}
	
	
	
}

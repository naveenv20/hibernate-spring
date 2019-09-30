package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class MyCloudlogAsyncAspect {

	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAOPexpressions.forDAOpacakagenogetternosetter()")
	public void logToCloudAsync() {
		System.out.println("\n ============>>>>> Before advise on the CLoud ()");
	}
	
}

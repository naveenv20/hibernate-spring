package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	//this is where we add all our related advices for logging 
	
	//lets start with an @Before advice
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(boolean add*())")
	// @Before("execution(* add*())")
	/*
	 * @ Before ( )
	 * Access type --private public etc  optional
	 * return type--
	 * full qualified class type --optional    ( package name. class. method)
	 * method
	 * parameters
	 */
	
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	/*
	 *   ()--irrespetive of arguments
	 *   * any one of the argument matched
	 *   .. 0 or more number of arguements matached
	 */
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	
	
	/*
	 * Point Cut Declaration 
	 * for reuability
	 */
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOpackage() {}
	//point cur for getter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//point cur for setter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//point cur for joining and exlcusing getter and setter
	@Pointcut("forDAOpackage () && !(getter() || setter())")
	private void forDAOpacakagenogetternosetter() {}
	
	
	//bfore using pointcut declaration name
	@Before("forDAOpacakagenogetternosetter()")
	public void beforeAddAccontAdvice() {
		
		System.out.println("\n ============>>>>> Before advise on the addAccount ()");
	}
	
	//Lets add one more advise
	@Before("forDAOpackage()")
	public void performAPIanalytics() {
		System.out.println("\n ============>>>>> Before advise on the Analytics ()");
	}
	
	
	
}

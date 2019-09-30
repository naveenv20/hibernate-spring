package com.luv2code.aopdemo.aspect;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(10)
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
	
	
	
	
	//bfore using pointcut declaration name
	@Before("com.luv2code.aopdemo.aspect.LuvAOPexpressions.forDAOpacakagenogetternosetter()")
	public void beforeAddAccontAdvice(JoinPoint theJoinPont) {
		
		System.out.println("\n ============>>>>> Before advise on the addAccount ()");
		
		
		// display the method signature
		MethodSignature methodsig= (MethodSignature) theJoinPont.getSignature();
		
		System.out.println("Method :   "+methodsig);
		
		
		//display the arguments
		Object[] args= theJoinPont.getArgs();
		
		
		for (Object temporg: args) {
			System.out.println(temporg);
			
			if(temporg instanceof Account){
				
				//downcast and  print account specific  stuff
				Account tempAccount= (Account) temporg;
				System.out.println("Account name : "+tempAccount.getName());
				
				System.out.println("Account Level : "+tempAccount.getLevel());
			}
		}
		
		
	}
	
	
	
	
	
	//add a new advic for after returning on findaccounts
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterreturningfindaccountsadvice(JoinPoint thejoinpoint,List<Account> result) {
		
		String method=thejoinpoint.getSignature().toShortString();
		System.out.println("\n ================Executing @ Afterreturning <<<"+method);
		
		System.out.println("\n ================Result <<<"+result);
		
		//lets post process the data --lets modify that 
		
		//convert the account names to uppercase
		
		convertAccountNamestoUppercase(result);
		
	}


	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExec"
			)
	public void afterThrowingfindaccountsAdvise(JoinPoint thejoinpoint,Throwable theExec){
		
		String method=thejoinpoint.getSignature().toShortString();
		System.out.println("\n ================Executing @ Afterthrowing <<<"+method);
		
		
		System.out.println("\n ========Exception is ========>>>"+theExec);
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afteradvisefindaccountsAdvise(JoinPoint thejoinpoint){
		String method=thejoinpoint.getSignature().toShortString();
		System.out.println("\n ================Executing @@@@ AfterAdvise  (finally bloack kind)  ======<<<"+method);
					
	}
	



	private void convertAccountNamestoUppercase(List<Account> result) {
		
		for (Account temp: result){
			
			temp.setName(temp.getName().toUpperCase());
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

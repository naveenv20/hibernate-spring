package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add an exception handle for customernotfoundexception (if customer with id is not found , null catching)
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//create customerError Response
		CustomerErrorResponse error=new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		//will rturn the 404 error 		
		//retun responseentity
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
	}
	
	
	//add another exceptionhandler ..to catch any other exception ( catch all kind) 
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		//create customerError Response
		CustomerErrorResponse error=new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		//will rturn the 400 error 
				
		//retun responseentity
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			
	}
	
	
	
}

package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add execpetoin hadnling code here
	
	//add another excpetionhandler for all generic cases
	
		//Add an exceptoin handler using @ExceptionHandler
		
		
			@ExceptionHandler
			public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
				
				// create a studenterrorresponse 
				StudentErrorResponse error=new StudentErrorResponse();
				
				//setting the values to this ohbject 
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage(exe.getMessage());
				error.setTimeStamp(System.currentTimeMillis());
				
				
				//return a response entity
				
				
				return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			}
			
			
			
			@ExceptionHandler
			public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
				
				// create a studenterrorresponse 
				StudentErrorResponse error=new StudentErrorResponse();
				
				//setting the values to this ohbject 
				error.setStatus(HttpStatus.NOT_FOUND.value());
				error.setMessage(exe.getMessage());
				error.setTimeStamp(System.currentTimeMillis());
				
				
				//return a response entity
				
				
				return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			}
			

}

package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	
	private List<Student> theStudents;
	
	
	//define @PostConstruct to load the student data only once
	@PostConstruct
	public void loadData(){
		theStudents=new ArrayList<>();
		
		theStudents.add(new Student("sai","ram"));
		theStudents.add(new Student("sai","krishna"));
		theStudents.add(new Student("sai","murali"));
		
	}
	
	
	@GetMapping("/students")
	//end point retuns list of students
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
	
	
	//define endpoint for "/students/${studentID}"  retunr student index
	
	@GetMapping("/students/{studentId}")
	//end point retuns list of students
	public Student getStudent(@PathVariable int studentId){
		
		//check if student is present or not .if not throw new exception throeu the class studnetnotfoundexception we have created
		if(studentId>=theStudents.size()||studentId<0){
			throw new StudentNotFoundException("Student id not found :"+studentId);
		}
		
		Student temp=theStudents.get(studentId);
		
		return temp ;
	}
	
	
	//Add an exceptoin handler using @ExceptionHandler
	
	
	
	
	
}

package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	//end point retuns list of students
	public List<Student> getStudents(){
		
		List<Student> thestudents=new ArrayList<>();
		
		thestudents.add(new Student("sai","ram"));
		thestudents.add(new Student("sai","krishna"));
		thestudents.add(new Student("sai","murali"));
		
		return thestudents;
	}
}

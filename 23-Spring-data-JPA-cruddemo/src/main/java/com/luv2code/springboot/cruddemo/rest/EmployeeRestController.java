package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//quick and dirty : inject employee dao
	
	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService){
		employeeService=theemployeeService;
	}
	
	// expose the endoint employees --return all employees
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// get mapping for single employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null){
			throw new RuntimeException("Employee id not found: "+ employeeId );
		}
		
		return theEmployee;
	

}
	
	
	//add mapping for post  employee -- add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		
		//also just in case they pass an id in json ...set it to 0 as we are adding a new employee
		//force uses to save item rather than update
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	
	
	// add mapping for update
	@PutMapping("/employees")
	
public Employee updateEmployee(@RequestBody Employee theEmployee){
		
		employeeService.save(theEmployee);
		
		
		return theEmployee;
}
	
	
	//delete the employee case
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		// throw if null
		if(theEmployee==null){
			throw new RuntimeException("Employee id not found: "+ employeeId );
		}
		
		employeeService.deleteById(employeeId);
		return "Delete Empid: "+employeeId;
	

}
	
	
}

package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// this JpaRepository is going to give all the Crud functions
	//findall
// find by id
	//save
	//delete
	//spring data jpa --using this 

	// add a method to sort by last name 
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// spring data JPA will parse the method name ..looks for a specific format and pattern
	//creates appropriate query ..behind the scenes
}

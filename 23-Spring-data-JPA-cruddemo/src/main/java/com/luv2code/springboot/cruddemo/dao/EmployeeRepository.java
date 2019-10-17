package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// this JpaRepository is going to give all the Crud functions
	//findall
// find by id
	//save
	//delete
	//spring data jpa --using this 

}

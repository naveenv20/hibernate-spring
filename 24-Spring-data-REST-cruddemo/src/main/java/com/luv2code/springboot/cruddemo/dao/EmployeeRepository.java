package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;


/*
 * Here is default  resource path is ...Entity's  name modified to lower furst character and s at end
 * Employee -> employees
 * u have to access like 
 * http://localhost:8080/employees/11
 * 
 * But if placed any proper in applicaton.properties like 
 * spring.data.rest.base-path=/magic-api
 * 
 *  then the url is 
 *  http://localhost:8080/magic-api/employees/11
 *  
 *  
 *  What if we dont need employees and some other name needed ? then 
 *  use @RepositoryRestResource(path="members")
 *   http://localhost:8080/magic-api/members/11
 * 
 * 
 * For page sizes 
 * spring.data.rest.default-page-size=20 ..one of a property
 * 
 * For Sorting 
 *  http://localhost:8080/magic-api/members?sort=lastName
 * 
 * 
 */

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// this JpaRepository is going to give all the Crud functions
	//findall
// find by id
	//save
	//delete
	//spring data jpa --using this 

}

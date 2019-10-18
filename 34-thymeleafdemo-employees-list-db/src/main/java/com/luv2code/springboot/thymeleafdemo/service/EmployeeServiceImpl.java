package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;





@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	
	// here two bean are qualified EmployeeDAOHibernateImpl and EmployeeDAOJPAImpl so 
	//using @ qualified specifying what we need
	//bean id with first letter small 'employeeDAOJPAImpl'
	//JpaRepository provides @ Transactional automatically 
	@Autowired
	
	public EmployeeServiceImpl (EmployeeRepository theemployeeRepository){
		employeeRepository=theemployeeRepository;
	}

	@Override
	
	public List<Employee> findAll() {
		
		// this is a default method 
		//return employeeRepository.findAll();
		
		// returning the option with sorted last name 
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		/***********************************
		 * JAVE OPTIONAL TYPE OF CODING HERE OBESERVE THIS
		 * luv2code.com/java-optional-tutorial
		 */
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theemployee=null;
		if(result.isPresent()) {
			theemployee=result.get();
			
		}
		
		else {
			throw new RuntimeException("Not found the employee with id : "+theId);
		}
		return theemployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}

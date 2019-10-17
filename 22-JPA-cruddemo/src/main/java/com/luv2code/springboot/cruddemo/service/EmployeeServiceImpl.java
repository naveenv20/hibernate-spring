package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	// here two bean are qualified EmployeeDAOHibernateImpl and EmployeeDAOJPAImpl so 
	//using @ qualified specifying what we need
	//bean id with first letter small 'employeeDAOJPAImpl'
	@Autowired
	
	public EmployeeServiceImpl (@Qualifier("employeeDAOJPAImpl")EmployeeDAO theemployeDAO){
		employeeDAO=theemployeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}

}

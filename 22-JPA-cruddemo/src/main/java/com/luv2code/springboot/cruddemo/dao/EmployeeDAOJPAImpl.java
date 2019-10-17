package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theentityManager) {
		entityManager=theentityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create a query
		
		//execute query and get result
		
		//return result
		
		Query thequery=entityManager.createQuery("from Employee");
		
		
		List<Employee> employees=thequery.getResultList();
		
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
	
		//get Employee
		
		Employee employee=entityManager.find(Employee.class,theId);
		
		
				//return
				
				
				return employee;
		
		
	}

	@Override
	public void save(Employee theEmployee) {
		
		//save or update 
		
		Employee dBemployee=entityManager.merge(theEmployee);
		
		
		//update with id from db
		theEmployee.setId(dBemployee.getId());
		
	}

	@Override
	public void deleteById(int theId) {
		
		
		//delete object  with primary ley
		
		Query theQuery=entityManager.createQuery(

				"delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}

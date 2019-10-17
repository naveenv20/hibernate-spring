package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;



@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	//define fields for Entitymanager
	private EntityManager entityManager;
	
	
	//set up constructor injeciton
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theentityManager){
		entityManager=theentityManager;
	}
	
	
	@Override
	
	public List<Employee> findAll() {
		
		//getthe current hibernate session 
		Session currentSession=entityManager.unwrap(Session.class);
		
		
		//cretae query
		Query<Employee> theQuery=currentSession.createQuery("from Employee", Employee.class);
		
		//execute query 	and	get results
		List<Employee> employess=theQuery.getResultList();
		
		

		
		//return results
		
		
		return employess;
	}


	@Override
	public Employee findById(int theId) {
		//get session
		Session currentSession=entityManager.unwrap(Session.class);
		//create query
		
		
		Employee theEmployee=currentSession.get(Employee.class,theId);
		
		//execute and result
		
		
		
		//return 
		return theEmployee;
		
		
		
		
		
		
	}


	@Override
	public void save(Employee theEmployee) {
		//get session
				Session currentSession=entityManager.unwrap(Session.class);
				//create query
				
				
				
				
				//save
				currentSession.saveOrUpdate(theEmployee);
				
				
				
				
				
		
	}


	@Override
	public void deleteById(int theId) {


		//get session
		Session currentSession=entityManager.unwrap(Session.class);
		//delete obj with primary key
		
		Query thequery=currentSession.createQuery(				
				"delete from Employee where id=:employeeId");
				
		//pass paramter
		thequery.setParameter("employeeId",theId);
				
		//execute
		thequery.executeUpdate();
		
		
	}

}

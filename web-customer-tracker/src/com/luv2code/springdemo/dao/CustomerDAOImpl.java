package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;




@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Customer> getCustomers() {
	
		
		//get current hiberate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//cretae a query nd sort by lastname
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by lastname",Customer.class);
		
		//execute query and get result
		List<Customer> customers=theQuery.getResultList();
			
		//return the result
		//System.out.println("abc");
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
     //get current hibernate session
		Session Currentsession=sessionFactory.getCurrentSession();
		
		
		//save the customer
		//Currentsession.save(thecustomer);
		Currentsession.saveOrUpdate(thecustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theid) {
		Session Currentsession=sessionFactory.getCurrentSession();
		Customer thecustomer=Currentsession.get(Customer.class, theid);
		
		return thecustomer;
		
	}

}

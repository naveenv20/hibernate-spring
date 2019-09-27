package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	//need to inject the CustomerDAO
	
	@Autowired
	private CustomerDAO customerDao;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		
		// we are deleteting the get customers work ro CustomerDAOImpl class 
		//as auto wired will a class of CLass which is implementing the CustomerDAO interface
		
		return customerDao.getCustomers();
	}



	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		
		customerDao.saveCustomer(thecustomer);
		
		
	}

	

}

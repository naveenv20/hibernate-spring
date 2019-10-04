package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//autowire customer service
	@Autowired
	private CustomerService customerService;
	
	//add mappinh for GET /customers
	
	@RequestMapping("/customers")
	public List<Customer> getcustomers(){
			
		return customerService.getCustomers();
		
	}
	
	//add mapping get customer --with customer id
	@RequestMapping("/customers/{customerId}")
	public Customer getcustomer(@PathVariable int customerId ){
			
		return customerService.getCustomer(customerId);
		
	}
	
}

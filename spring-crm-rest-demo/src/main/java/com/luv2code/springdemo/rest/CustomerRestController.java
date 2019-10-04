package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
			
		Customer thecustomer=customerService.getCustomer(customerId);
		
		if(thecustomer==null){
			throw new CustomerNotFoundException("Customer not found - "+customerId);
		}
		
		return thecustomer;
		
	}
	
	
	
	//add mapping for POST /customers     adding a new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		
		
		//also just in the case the pass the id in JSON ...set id to 0
		//this is force a save of new item .. instead of doing update 
		customerService.saveCustomer(theCustomer);
		
		
		return theCustomer;
		
	}
	
	
	// add mapping for PUT /customers for updating the customers
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		
		//also just in the case the pass the id in JSON ...set id to the value u want delete
		//
		customerService.saveCustomer(theCustomer);
		
		
		return theCustomer;
		
	}
	
	
	// add mapping for DELETE /customers for deleting the customer
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer thecustomer = customerService.getCustomer(customerId);
		
		// checking if the customer exists
		if(thecustomer==null){
			throw new CustomerNotFoundException("Customer not found - "+customerId);
		}
		
		
		
		//also just in the case the pass the id in JSON ...set id to the value u want delete
	
		customerService.deleteCustomer(customerId);
		
		
		return "Delete Customer id :  "+customerId;
		
	}
	
	
}

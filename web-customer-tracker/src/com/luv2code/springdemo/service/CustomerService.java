package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theid);

	public void deleteCustomer(int theid);

	public List<Customer> searchCustomers(String theSearchName);
	
	
}

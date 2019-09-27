package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//need to inject the customer DAO
	//** as the service is now having this logic of depen injection removing here 
	//@Autowired
	//private CustomerDAO customerDAO;
	
	//need to inject the Customer service now
	@Autowired
	private CustomerService customerService;

	   // @RequestMapping("/list")
	    @GetMapping("/list")
	    //only accepting the 'get' method requests , request mapping is general we use this is enhancement to that 
	       public String listCustomer(Model themodel){
	    	
	    	//get customer from the dao
	    	//List<Customer> theCustomers=customerDAO.getCustomers();
	    	
	    	//using the service layer
	    	List<Customer> theCustomers=customerService.getCustomers();
	    	// add the customer to the model
	    	themodel.addAttribute("customers",theCustomers);
	    	
	    	
	    	
			return "list-customers";
	    	
	    }
	    
	    
	   
	    @GetMapping("/showFormForAdd")
	    public String showFormForAdd(Model themodel) {
	    	
	    	//create a model attribute to bind the form data
	    	Customer thecustomer= new Customer();
	    	themodel.addAttribute("customer",thecustomer);
	    	
	    	  	
			return "customer-form";
	    	
	    }
	    
	    @PostMapping("/saveCustomer")
	    public String savecustomer(@ModelAttribute("customer") Customer thecustomer, Model themodel) {
	    	
	    	
	    	//save the customer  using our service
	    	customerService.saveCustomer(thecustomer);
	    	
	    	List<Customer> theCustomers=customerService.getCustomers();
//	    	// add the customer to the model
//	    	themodel.addAttribute("customers",theCustomers);
//	    	
//	    	return "list-customers";
	    	 return  "redirect:/customer/list";
	    }
	    
	
}

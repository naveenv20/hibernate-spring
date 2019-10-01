package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	    	
	    	//List<Customer> theCustomers=customerService.getCustomers();
//	    	// add the customer to the model
//	    	themodel.addAttribute("customers",theCustomers);
//	    	
//	    	return "list-customers";
	    	 return  "redirect:/customer/list";
	    }
	    
	
	    
	    
	    @GetMapping("/showFormForUpdate")
	    public String showFormforUpdate(@RequestParam("customerId") int theid, Model themodel){
	    	
	    	// get the customer from the service
	    	Customer thecustomer=customerService.getCustomer(theid);
	    	
	    	
	    	//set customer as a model attribute to prepopulate the form
	    	themodel.addAttribute("customer",thecustomer);
	    	
	    	
	    	//send over to our form
	    	  	
			return "customer-form";
	    	
	    }
	    
	    
	    @GetMapping("/deleteCustomer")
	    public String deleteCustomer(@RequestParam("customerId") int theid, Model themodel){
	    	
	    	
	    	
	    	//delete the customer
	    	customerService.deleteCustomer(theid);	
	    	
	    	
	    	//send over to our form
	    	  	
			return "redirect:/customer/list";
	    	
	    }
	    
	    @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search customers from the service
	        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customers", theCustomers);

	        return "list-customers";        
	    }
	    
}

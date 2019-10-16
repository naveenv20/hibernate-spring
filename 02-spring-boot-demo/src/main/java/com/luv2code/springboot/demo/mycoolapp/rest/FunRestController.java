package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	
	// expose / end point  that will return hello world
	@GetMapping("/")
	public String sayHello(){
		return "Hello World !!! TIme is : "+ LocalDateTime.now(); 
	}
	
	
	//expose end point for workout
	@GetMapping("/workout")
	public String getDailyWorkout(){
		return "Run 10K !!!"; 
	}

}

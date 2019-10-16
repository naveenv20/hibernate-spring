package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	
	//inject avlaes from properties file 
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	// expose / end point  that will return hello world
	@GetMapping("/")
	public String sayHello(){
		return "Hello World !!! TIme is : "+ LocalDateTime.now(); 
	}
	
	
	//expose end point for workout
	@GetMapping("/workout")
	public String getDailyWorkout(){
		return "Run 15K !!!"; 
	}

	
	
	
	//sample actuators
	//http://localhost:8080/actuator/health
	//http://localhost:8080/actuator/info
	
	
	
	//end point for displaying the properties vaues
	@GetMapping("/teaminfo")
	public String getTeaminfo()
	{	
	
	return "Coach Name : "+coachName+"  Team Name: "+teamName;
	}
}

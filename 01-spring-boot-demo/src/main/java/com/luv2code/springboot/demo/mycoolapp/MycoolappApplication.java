package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {

	//http://start.spring.io-- for creating the intial project 
	// created a web project there .. spring boot will aumatically created the config files .and all the xml or java code configurations
	//"spring-boot-starter-web"
	
	
	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}

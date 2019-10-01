package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try{
			//create the object mapper
			ObjectMapper mapper= new ObjectMapper();
			//read json file and map/conver to java pojo
			
			//data/sample-lite.json
			Student thestudent=mapper.readValue(
					//new File("data/sample-lite.json"), Student.class);
					new File("data/sample-full.json"), Student.class);
		
		
				
			//print details
			System.out.println("Firstname:  "+thestudent.getFirstname());
			System.out.println("Lastname:  "+thestudent.getLastname());
			
			//print address
			Address tempAdress=thestudent.getAddress();
			
			System.out.println("Street name : "+tempAdress.getStreet());
			
			//print languages
			for (String temp:thestudent.getLanguages()){
				System.out.println("languages: "+temp);
			}
			
			
		}
		catch (Exception exe){
			exe.printStackTrace();	
		}

	}

}

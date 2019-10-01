package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
//ignore the unknow properties 
public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private boolean active;
	private Address address;
	private String[] languages;
	
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	} 
	

	public Student(){
		
	}
}

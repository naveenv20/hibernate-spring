package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.ibm.xtq.xslt.runtime.RuntimeError;


@Component
public class TrafficFortuneService {

	
	public String getFortune(){
		
		//simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return a fortune
		
		return "Heavry Traffic this morning";
		
	}

	public String getFortune2(boolean tripwire) {
		
		if(tripwire){
			
			throw new RuntimeException("highway closedd !!!!!!!!!!!!!!!!!!!!");
		}
		
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect Heavy traffic this morning";
	}
	
	
}

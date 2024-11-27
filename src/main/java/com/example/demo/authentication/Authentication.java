package com.example.demo.authentication;

import com.example.demo.systemUsers.Driver;

import com.example.demo.systemUsers.Passenger;

import com.example.demo.inputClasses.LoginInput;

import com.example.demo.ApplicationHandler;

public class Authentication implements IAuthentication {

	public String RegisterPassenger( Passenger passenger) {
        
	       return ApplicationHandler.getData().addPassenger(passenger);

	}

	public String RegisterDriver( Driver driver) {
        
	       return ApplicationHandler.getData().addDriver(driver);

	}

	
     public String login( LoginInput credintials){
		 return ApplicationHandler.getData().login(credintials);
	 }
}

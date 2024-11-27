package com.example.demo.systemUsers;

import java.util.ArrayList;

import com.example.demo.Actions;
import com.example.demo.ApplicationHandler;

public class Admin extends User {


	
	public Admin(String username, String mobileNumber, String email, String password , String birthDate) {
		super(username, mobileNumber, email, password , birthDate);
	}

	public String verifydriverRegistration(String username) {
		 return ApplicationHandler.getData().verifydriverRegistration(username);
	}

	public String suspend(String username){
		return ApplicationHandler.getData().suspend(username);
	}

	public String unsuspend(String username) {
		return ApplicationHandler.getData().unsuspend(username);
	}

	public void addDiscount(String destination ){
		ApplicationHandler.getData().addDiscountedDestination(destination);
	}
	public ArrayList<Actions> showRideActions (String passengerName,String source)
	{
		return ApplicationHandler.getData().getRideActions(passengerName, source);


	}
}
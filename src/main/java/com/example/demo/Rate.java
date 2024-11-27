package com.example.demo;
public class Rate {

	private String passengerName;
	private String driverName;
	private int rate;
	

	public Rate(String passengerName, String driverName, int rate) {
		
		this.passengerName = passengerName;
		this.rate = rate;
		this.driverName = driverName;
	}
	
	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}

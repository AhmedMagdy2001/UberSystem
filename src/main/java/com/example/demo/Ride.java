package com.example.demo;

import java.util.ArrayList;

public class Ride {

	
	private String source;
	private String destination;
	private double price = 0;
	private String driverName;
	private boolean accepted = false;
	private boolean completed;
	private int maxNumOfPassengers;
    private int servicedPassengers = 0;
	private ArrayList<Actions> actions = new ArrayList<>();


	
	public ArrayList<Actions> getActions() {
		return actions;
	}

	public void addAction(Actions action) {
		actions.add(action);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public Ride(String source, String destination,int maxNumOfPassengers) {
		this.source = source;
		this.destination = destination;
        this.maxNumOfPassengers = maxNumOfPassengers;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price, String driverName) {
		this.price = price;
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
		ApplicationHandler.getData().unNotifyDrivers(this);
	}
	public int getMaxNumberOfPassengers() {
		return maxNumOfPassengers;
	}

	public void setNumberOfPassengers(int maxNumOfPassengers) {
		this.maxNumOfPassengers = maxNumOfPassengers;
	}
	public int getServicedPassengers() {
		return servicedPassengers;
	}

	public void increaseServicedPassengers() {
		this.servicedPassengers++;
	}


}

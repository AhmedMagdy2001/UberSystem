package com.example.demo.Database;
import java.util.ArrayList;

import com.example.demo.Actions;
import com.example.demo.FavouriteArea;
import com.example.demo.Rate;
import com.example.demo.Ride;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;



public class ArrayStorage implements Database {


	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private ArrayList<Rate> Ratings = new ArrayList<Rate>();
	private ArrayList<Ride> Rides = new ArrayList<Ride>();
	private ArrayList<FavouriteArea> FavAreas = new ArrayList<FavouriteArea>();
    private ArrayList<String> DiscountedDestinations = new ArrayList<String>(); 

	
	public void addRating(Rate rating) {
		this.Ratings.add(rating);
	}

	public void addRide(Ride ride , Passenger passenger ) {

		for(int i = 0 ; i < Rides.size(); i++) { 

			if(ride.getSource().equals(Rides.get(i).getSource())&& ride.getDestination().equals(Rides.get(i).getDestination())){
				if(ride.getMaxNumberOfPassengers() > Rides.get(i).getServicedPassengers() && Rides.get(i).getMaxNumberOfPassengers() > ride.getServicedPassengers()){

                     Rides.get(i).increaseServicedPassengers();
                     passenger.getRide().increaseServicedPassengers();
					 return;
				}
			}
		}
		Rides.add(ride);
	}

	public ArrayList<Actions> getRideActions(String passengerName,String source )
	{
		for (Passenger p : passengers) {
			if(p.getUsername().equals(passengerName)&&p.getRide().getSource().equals(source))
			{
				return p.getRide().getActions();
			}
		}
		return null ;
	}

	public String addFavArea(FavouriteArea favArea) {
		this.FavAreas.add(favArea);

		return "added " +favArea.getSource()+" to your favourite areas";
	}

	public ArrayList<Rate> getRatings() {
		return Ratings;
	}

	public ArrayList<Ride> getRides() {
		return Rides;
	}
	
	public ArrayList<FavouriteArea> getFavAreas() {
		return FavAreas;
	}

	public String login(LoginInput credintials) {

	
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(credintials.username)
					&& passengers.get(i).getPassword().equals(credintials.password)) {
                
						if(passengers.get(i).getSuspend()){
							return "you have been suspended";
						}
						else{
							return "You have been logged in";
						}
				
			}
		}
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(credintials.username)
					&& drivers.get(i).getPassword().equals(credintials.password)) {
				if (drivers.get(i).isVerify()) {
					if(drivers.get(i).getSuspend()){
						return "you have been suspended";
					}
					else{
						return "You have been logged in";
					}
				} else {
					return  "You haven't been verified yet";
				}

			}
		}

		return null;
	}
	
	public Passenger getPassengerByUsername(String username) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {

				return passengers.get(i);
			}
		}

		return null;
	}

	public Driver getDriverByUsername(String username) {
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				return drivers.get(i);
			}
		}

		return null;
	}

	public String verifydriverRegistration(String username) {

		for (int i = 0; i < this.drivers.size(); i++) {

			if (this.drivers.get(i).getUsername().equals(username)) {

				this.drivers.get(i).setVerify(true);

				return "driver verified";
			}
		}
		return null;
	}

	public void ListdriverRegistrations() {

		for (int i = 0; i < this.drivers.size(); i++) {
			if (!this.drivers.get(i).isVerify()) {
				System.out.println("|' Username: " + this.drivers.get(i).getUsername());
				System.out.println("|  Nationalid:" + this.drivers.get(i).getNationalId());
				System.out.println("|' Drivinglicense: " + this.drivers.get(i).getDrivingLicense() + "\n");
			}

		}

	}

	public void listDrivers() {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i) instanceof Driver) {
				System.out.println("Driver's name: " + drivers.get(i).getUsername());
			}
		}
	}

	public ArrayList<String> listAllRides() {
		ArrayList<String> allRides = new ArrayList<String>();

		for (int i = 0; i < passengers.size(); i++) {
			
			if (passengers.get(i).getRide() != null && !passengers.get(i).getRide().isAccepted()) {
				allRides.add(passengers.get(i).getUsername() + " has requested a ride from "
						+ passengers.get(i).getRide().getSource() + " to " + passengers.get(i).getRide().getDestination());
			}
			

		}
		return allRides;
	}

	public String suggestRidePrice(String source, double price, String driverName , String passengerName) {

		for (int i = 0; i < passengers.size(); i++) {

			if (passengers.get(i).getRide().getSource().equals(source)&&passengers.get(i).getUsername().equals(passengerName) &&
			                                                                                        !passengers.get(i).getRide().isAccepted()) {

				passengers.get(i).getRide().setPrice(price, driverName);
			}
			else if(passengers.get(i).getRide().isAccepted()){
				return "this ride is already taken by another driver";
			}

		}
		return null;

	}

	public ArrayList<String>  listUsersRatings(Driver driver) {
        ArrayList<String> usersRatings = new ArrayList<String>();
		
		for (int i = 0; i < this.Ratings.size(); i++) {

			if (this.Ratings.get(i).getDriverName().equals(driver.getUsername())) {
			usersRatings.add("Passenger: " + this.Ratings.get(i).getPassengerName() + "-> Rate: "
						+ this.Ratings.get(i).getRate());

			}

		}
		return usersRatings;

	}

	public String checkDriverAvgRating(String driverName) {

		int average = 0;

		for (int i = 0; i < this.Ratings.size(); i++) {
			if (this.Ratings.get(i).getDriverName().equals(driverName)) {
				average += this.Ratings.get(i).getRate();
				average = average / this.Ratings.size();
			}

		}

		return driverName + " got rating: "+String.valueOf(average);
	}

	public String addPassenger(Passenger passenger) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(passenger.getUsername())
					&& passengers.get(i).getPassword().equals(passenger.getPassword())) {
                
               return "This passenger already Exists !";
			}
		}
		this.passengers.add(passenger);
		return "registeration completed";
	}

	public String addDriver(Driver driver) {
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(driver.getUsername())
					&& drivers.get(i).getPassword().equals(driver.getPassword())) {

				return "This driver already Exists !";
		}
	}
		this.drivers.add(driver);
		return "registeration completed";
	}

	public void notifyAllDrivers(Ride ride){

		for(int i = 0 ; i< FavAreas.size();i++){
			if(FavAreas.get(i).getSource().equals(ride.getSource())){
			 Driver driver = getDriverByUsername(FavAreas.get(i).getDriverName());

			 if(driver.isAvailable()){
				driver.requestedRides.add(ride);
			 }
              

			}
			
		}
	}

	public void unNotifyDrivers(Ride ride){
		for(int i = 0 ; i< drivers.size();i++){
			for(int j = 0 ; j <drivers.get(i).requestedRides.size();j++){
				if(drivers.get(i).requestedRides.get(j).equals(ride)){
					drivers.get(i).requestedRides.remove(j);
				}
			}
			
		}
	}

	public String suspend(String username) {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				drivers.get(i).setSuspend(true);

				return drivers.get(i).getUsername()+" has been suspended";
			}
		}
		for (int i = 0; i < this.passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {
				passengers.get(i).setSuspend(true);

				return passengers.get(i).getUsername()+" has been suspended";
			}
		}
		return null;
	}

	public String unsuspend(String username) {
		for (int i = 0; i < this.drivers.size(); i++) {
			if (drivers.get(i).getUsername().equals(username)) {
				drivers.get(i).setSuspend(false);
				
				return drivers.get(i).getUsername()+" has been unsuspended";
			}
		}
		for (int i = 0; i < this.passengers.size(); i++) {
			if (passengers.get(i).getUsername().equals(username)) {
				passengers.get(i).setSuspend(false);

				return passengers.get(i).getUsername()+" has been unsuspended";
			}
		}
		return null;
	}

	public void listSuspendedUsers() {
		System.out.println("suspended users \n");

		for (int i = 0; i < this.passengers.size(); i++) {
			if (this.passengers.get(i).getSuspend()) {
				System.out.println((i + 1) + "- " + this.passengers.get(i).getUsername());
			}

		}
		for (int i = 0; i < this.drivers.size(); i++) {
			if (this.drivers.get(i).getSuspend()) {
				System.out.println((i + 1) + "- " + this.drivers.get(i).getUsername());
			}

		}
	}

	public boolean checkDiscountedDestination(String destination) {
		for(int i = 0 ; i < DiscountedDestinations.size();i++){
			if(DiscountedDestinations.get(i).equals(destination)){
				return true;
			}
		}
		return false;
	}

	public void addDiscountedDestination(String destination) {
		DiscountedDestinations.add(destination); 
	}

	
}

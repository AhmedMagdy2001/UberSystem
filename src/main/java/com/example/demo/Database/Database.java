package com.example.demo.Database;
import java.util.ArrayList;

import com.example.demo.Actions;
import com.example.demo.FavouriteArea;
import com.example.demo.Rate;
import com.example.demo.Ride;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

public interface Database {

	public void addRide(Ride ride ,  Passenger passenger);

	public void addRating(Rate rating);

	public String addFavArea(FavouriteArea favArea);


	//public void addNewDriver(Driver driver);

	public String addPassenger(Passenger passenger);

	public String addDriver(Driver driver);

	public void notifyAllDrivers(Ride ride);

	public void unNotifyDrivers(Ride ride);

	String login(LoginInput credintials);

	public Passenger getPassengerByUsername(String username);

	public Driver getDriverByUsername(String username);

	//public ArrayList<Driver> getPendingRegistrations();

	public ArrayList<Rate> getRatings();

	public ArrayList<Ride> getRides();

	public ArrayList<FavouriteArea> getFavAreas();

	public void ListdriverRegistrations();

	public String verifydriverRegistration(String username);

	public void listDrivers();

	public ArrayList<String> listAllRides();

	public String suggestRidePrice(String source, double price, String driverName , String passengerName);

	ArrayList<String> listUsersRatings(Driver driver);

	String checkDriverAvgRating(String driverName);

	public String suspend(String username);

	public String unsuspend(String username);

	public void listSuspendedUsers();

	public boolean checkDiscountedDestination(String destination);

	public void addDiscountedDestination(String destination);
	
	public ArrayList<Actions> getRideActions(String passengerName,String source );

	public void addHolidayDate(String date) ;
	
	public boolean isHoliday(String date);
	
}

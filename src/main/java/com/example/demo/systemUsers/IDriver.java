package com.example.demo.systemUsers;

import java.util.ArrayList;

public interface IDriver  {
    public String addFavArea(String source);

	public ArrayList<String> listAllRides();

	public String suggestPrice(String source , String passengerName, double price);

	public ArrayList<String> listRatings();

	public String getDrivingLicense();

	public String getNationalId();

	public boolean isVerify();

	public void setVerify(boolean verify);

	public boolean isAvailable();

	public void setAvailable(boolean available);
    
}

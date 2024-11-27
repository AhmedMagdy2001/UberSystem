package com.example.demo.systemUsers;

import com.example.demo.Rate;
import com.example.demo.Ride;

public interface IPassenger {
    public void requestAride(String source, String destination, int maxNumOfPassengers);

    public void rateDriver(Rate rating);

    public void removeRide();

    public Ride getRide();

    public boolean isFirstRideDiscountAvailable();

    public void didFirstRide();
}

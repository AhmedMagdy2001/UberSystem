package com.example.demo;

import java.time.LocalDate;
import java.util.Date;

public class Actions {
    String actionName ;
    String actionTime ;
    String driverName;
    String passengerName ;
    double price ;
    

    
    public Actions(String actionName, String actionTime) {
        this.actionName = actionName;
        this.actionTime = actionTime;
    }


    public String getActionName() {
        return actionName;
    }
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
    public String getActionTime() {
        return actionTime;
    }
    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
    


}
package com.example.demo.authentication;

import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

public interface IAuthentication {

    public String RegisterPassenger(Passenger passenger);

    public String RegisterDriver(Driver driver);

    public String login(LoginInput credintials);
}
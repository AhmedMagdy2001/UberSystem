package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.demo.Actions;
import com.example.demo.ApplicationHandler;
import com.example.demo.FavouriteArea;
import com.example.demo.Ride;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.inputClasses.driverInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")

public class driverController {

   @PostMapping("/addFavouriteArea")
   public String addFavouriteArea(@RequestBody driverInput input) {
      Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);

      return driver.addFavArea(input.source);
   }

   @PostMapping("/suggestPrice")
   public String suggestPrice(@RequestBody driverInput input) {
      Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);

      Actions action = new Actions("putPrice",
            new SimpleDateFormat("d-M").format(Calendar.getInstance().getTime()));
      action.setDriverName(input.driverUsername);
      action.setPrice(input.price);

      ApplicationHandler.getData().getPassengerByUsername(input.passengerUsername).getRide().addAction(action);

      return driver.suggestPrice(input.source, input.passengerUsername, input.price);

   }

   @PostMapping("/arriveAtSource")
   public void arriveAtSource(@RequestBody driverInput input) {
      Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(input.passengerUsername);

      Actions action = new Actions("arrivedAtSource",
            new SimpleDateFormat("d-M").format(Calendar.getInstance().getTime()));
      action.setDriverName(input.driverUsername);
      action.setPassengerName(input.passengerUsername);
      passenger.getRide().addAction(action);
   }
   
   @PostMapping("/completeRide")
   public void completeRide(@RequestBody driverInput input) {
      Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
      Passenger passenger = ApplicationHandler.getData().getPassengerByUsername(input.passengerUsername);

      driver.setAvailable(true);
      Actions action = new Actions("arrivedAtDestination",
            new SimpleDateFormat("d-M").format(Calendar.getInstance().getTime()));
      action.setDriverName(input.driverUsername);
      action.setPassengerName(input.passengerUsername);
      passenger.getRide().addAction(action);

   }

   @GetMapping("/listRatings")
   public ArrayList<String> listRatings(@RequestBody driverInput input) {
      Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
      return driver.listRatings();

   }

   @GetMapping("/listRides")
   public ArrayList<String> getRides(@RequestBody driverInput input) {
      Driver driver = ApplicationHandler.getData().getDriverByUsername(input.driverUsername);
      return driver.listAllRides();
   }

   

}

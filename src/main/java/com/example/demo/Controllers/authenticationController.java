package com.example.demo.Controllers;


import com.example.demo.ApplicationHandler;
import com.example.demo.authentication.Authentication;
import com.example.demo.authentication.IAuthentication;
import com.example.demo.inputClasses.LoginInput;
import com.example.demo.systemUsers.Driver;
import com.example.demo.systemUsers.Passenger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")

public class authenticationController {

	IAuthentication authentication = new Authentication();

	@PostMapping("/registerPassenger")
	public String RegisterPassenger(@RequestBody Passenger passenger) {
        
	       return authentication.RegisterPassenger(passenger);

	}
	@PostMapping("/registerDriver")
	public String RegisterDriver(@RequestBody Driver driver) {
        
	       return  authentication.RegisterDriver(driver);

	}

	 @PostMapping("/login")
     public String login(@RequestBody LoginInput credintials){
		 return authentication.login(credintials);
	 }
	

}

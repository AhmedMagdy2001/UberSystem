package com.example.demo.Controllers;

import java.util.ArrayList;

import com.example.demo.Actions;
import com.example.demo.DemoApplication;
import com.example.demo.Database.Database;
import com.example.demo.inputClasses.adminInput;
import com.example.demo.systemUsers.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class adminController {

	

	Admin admin = new Admin("Ahmed", "1231451",  "Ahmed@gmail.com",  "123456");
	
	@PostMapping("/verifyDriver")
	public String verifyDriver(@RequestBody adminInput input) {
		 return admin.verifydriverRegistration(input.driverUsername);
	}

	@PostMapping("/suspend")
	public String suspend(@RequestBody adminInput input) {
		return admin.suspend(input.driverUsername);
	}

	@PostMapping("/unsuspend")
	public String unsuspend(@RequestBody adminInput input) {

		return admin.unsuspend(input.driverUsername);
	}

	@PostMapping("/addDiscount")
	public void addDiscount(@RequestBody adminInput input){
		admin.addDiscount(input.area);
	}
	
	@GetMapping("/showRideActions")
	public ArrayList<Actions> showRideActions(@RequestBody adminInput input)
	{
		return admin.showRideActions(input.passengerUsername, input.source);
	}


}
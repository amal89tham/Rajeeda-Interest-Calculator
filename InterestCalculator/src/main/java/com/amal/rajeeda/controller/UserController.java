package com.amal.rajeeda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.amal.rajeeda.dao.LoginRepo;
import com.amal.rajeeda.model.InterestCalculator;
import com.amal.rajeeda.model.User;
import com.amal.rajeeda.services.InterestCalculatorService;
import com.amal.rajeeda.services.UserService;

@Controller
public class UserController {

	@Autowired
	LoginRepo loginRepo;

	@Autowired
	UserService userSer;

	@Autowired
	InterestCalculatorService ictServices;

	@RequestMapping("")
	public String login() {
		return "login.jsp";
	}

	@RequestMapping("/login")
	public String loginVerify(User user, ModelMap mp) {

		if (userValidator(user) == true) {

			if ((user.getUsername().equals(userSer.getUser().getUsername()))
					&& (user.getPassword().equals(userSer.getUser().getPassword()))) {

				System.out.println("Username Password Correct, ur in Interest Calculator");
				
				System.out.println("in calculator");

				List<InterestCalculator> inf;
				try {
					inf = ictServices.findAllValues();
					mp.put("inf", inf);
				} catch (Exception e) {
					System.out.println("Error in fetcing User Logins");
				}

				return "interestCalculator.jsp";
			}

			else {

				mp.addAttribute("message", "Your not provided valid username and password");
				System.out.println("Your not provided valid username and password");

				return "login.jsp";
			}
		} else {

			mp.addAttribute("message", "Please enter the user name and password");
			System.out.println("Please enter the user name and password");

			return "login.jsp";
		}

	}

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String loadInterestValues(InterestCalculator cal, ModelMap mp) {
	
		List<InterestCalculator> inf = ictServices.findAllValues();
		System.out.println("in cal");

		for (InterestCalculator data : inf) {
			
			double newInterest =0;
			try {				
				newInterest = Double.parseDouble(String.format("%.2f", ((data.getBalance()*data.getInterestRate()) / 100)));
				
				System.out.println("New interest "+newInterest);
			} catch (Exception e) {
				System.out.println("Error in interest calculating");
			}
			
			data.setInterest(newInterest);
		}
		ictServices.update(inf);

		mp.put("inf", inf);

		return "interestCalculator.jsp";
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public String clearInterestValues(InterestCalculator cal, ModelMap mp) {

		
		List<InterestCalculator> inf = ictServices.findAllValues();

		for (InterestCalculator data : inf) {
			data.setInterest(0);
		}

		mp.put("inf", inf);
		ictServices.update(inf);

		return "interestCalculator.jsp";
	}


	// User null Checking with Client
	public Boolean userValidator(User user) {
		if (user.getUsername() == null || user.getPassword() == null) {
			return false;
		} else
			return true;
	}
}

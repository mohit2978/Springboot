package com.mohit.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String getWelcome() {

	String msg = "Welcome to Ashok IT...!!";
	return msg;
	
	}
}


package com.mohit.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/greet")
	public String getWelcome() {

	String msg = "hi greetings!!";
	return msg;
	
	}
}


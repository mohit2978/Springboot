package com.mohit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	private WelcomeClient welcomeClient;
	
	@GetMapping("/greet")
	public String getWelcome() {
		
	String welcomeMsg = welcomeClient.invokeWelcomeApi();
	String msg = "hi greetings!!";
	
	
	return msg.concat(welcomeMsg);
	
	}
}


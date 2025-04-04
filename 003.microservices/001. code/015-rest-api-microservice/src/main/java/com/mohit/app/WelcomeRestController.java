package com.mohit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	Environment env;

	@GetMapping("/welcome")
	public String getWelcome() {

	String msg = "Welcome to Ashok IT...!!";
	String port = env.getProperty("server.port");
	msg = msg + "<br/>" + port;
	return msg;
	
	}
}


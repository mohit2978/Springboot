package com.mohit.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String getMsg() {
		return "welcome to Ashok IT";
	}
	
	@GetMapping("/welcome")
	public String welcome(@AuthenticationPrincipal OAuth2User user) {
		return "Welcome Bro!!"+user.getAttribute("name");
	}
	
	@GetMapping("/loggedin")
	public String logIn() {
		return "Welcome to App";
	}
}

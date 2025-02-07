package com.example.demo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.UserNotFoundException;

@RestController
public class UserController {
	
	@GetMapping("/user/{uid}")
	public String getNameById(@PathVariable("uid")  Integer uid) {
		
		if(uid <= 100) {
			return "Balu";
		}else {
			
			throw  new UserNotFoundException("Invalid user id");
		}
	}
	

}

package com.demo.mohit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("/greet")
	public String getGreetMsg(@RequestParam("name") String name) {
		String msg = name+", Good Morning..!!";
		return msg;
	}

	@GetMapping("/welcome/{name}")
	public ResponseEntity<String> getWelcomeMsg(@PathVariable("name") String name) {
		String msg = name+", Welcome to REST API..!!";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/action")
	public ResponseEntity<Void> doAction() {
		System.out.println("doAction () metdod called...");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

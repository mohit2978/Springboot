package com.example.demo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
	@GetMapping("/welcome")
	public String getMsg() {
		
		String msg = "Welcome To Ashok It";
		int i = 10/0;
		
		return msg;
		
	}
	

}

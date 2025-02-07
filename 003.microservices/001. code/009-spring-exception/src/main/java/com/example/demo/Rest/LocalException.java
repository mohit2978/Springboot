package com.example.demo.Rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ExceptionInfo.AppExInfo;

@RestController
public class LocalException {

	@GetMapping("/local/welcome")
	public String getMsg() {
		
		String msg = "Welcome To Ashok It";
		int i = 10/0;
		
		return msg;
		
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<AppExInfo> handleAE(ArithmeticException e){
		
		AppExInfo info = new AppExInfo();
		
		info.setExCode("from local exception handler");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());
	
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

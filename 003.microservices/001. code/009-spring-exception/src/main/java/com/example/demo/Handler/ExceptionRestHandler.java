package com.example.demo.Handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.ExceptionInfo.AppExInfo;

@RestControllerAdvice
public class ExceptionRestHandler {

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AppExInfo> handleAE(UserNotFoundException e){
		
		AppExInfo info = new AppExInfo();
		
		info.setExCode("SBTEX100");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());
	
		return new ResponseEntity<>(info,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppExInfo> handleAE(Exception e){
		
		AppExInfo info = new AppExInfo();
		
		info.setExCode("SBTEX007");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());
	
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

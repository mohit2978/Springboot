package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.*;
@SpringBootApplication
@EnableScheduling
public class Scheduling1Application {

	public static void main(String[] args) {
		System.out.println("Application started at"+new Date());
		SpringApplication.run(Scheduling1Application.class, args);
		System.out.println("Application ended at"+new Date());
	}

}

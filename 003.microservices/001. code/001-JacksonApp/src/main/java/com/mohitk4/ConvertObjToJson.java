package com.mohitk4;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertObjToJson {
	
public static void main(String[] args) throws Exception {
		
		Customer c = new Customer(101, "mohit kumar", "mohit.k4@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("customer.json"), c);
	
		System.out.println("completed...");
}
}

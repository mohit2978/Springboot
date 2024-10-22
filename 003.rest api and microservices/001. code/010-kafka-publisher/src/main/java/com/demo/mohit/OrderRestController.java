package com.demo.mohit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class OrderRestController {
	
	@Autowired
	public OrderService orderService;
	
	@PostMapping("/order")
	public String placeOrder( @RequestBody Order order) {
		
		 return orderService.publishMsg1(order);
		
		
	}

}
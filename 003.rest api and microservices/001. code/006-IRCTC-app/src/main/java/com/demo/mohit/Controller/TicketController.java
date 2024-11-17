package com.demo.mohit.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mohit.models.Passenger;
import com.demo.mohit.models.Ticket;
import com.demo.mohit.service.TicketService;

@RestController
public class TicketController {
	@Autowired
	private TicketService service;
	
	
	
	
	
	@PostMapping(value="/ticket",
			consumes="application/json",
			produces="application/json"
			)
	
	public ResponseEntity<Ticket> bookTicket(@RequestBody  Passenger p){
		Ticket ticket = service.bookTicket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/tickets",
			produces="application/json"
			)
	public ResponseEntity<Collection<Ticket>> getAllTickets(){
		Collection<Ticket> allTickets = service.getAllTickets();
		return new ResponseEntity<>(allTickets,HttpStatus.OK);
	}
}

package com.demo.mohit.services;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.mohit.models.Passenger;
import com.demo.mohit.models.Ticket;



@Service
public class MakeMyTripService {

	
	// consumer Logic
		public Ticket bokticket(Passenger p) {
			
			String url = "http://35.154.134.229:8081/ticket";
			
			RestTemplate rt = new RestTemplate();
			
			ResponseEntity<Ticket> forEntity = rt.postForEntity(url, p, Ticket.class);
			
			Ticket body = forEntity.getBody();
			
			return body;
			
			
			
		}
		
		public List<Ticket> getAllTickets(){
			String url = "http://35.154.134.229:8081/tickets";
			RestTemplate rt = new RestTemplate();
			
			ResponseEntity<Ticket[]> forEntity = rt.getForEntity(url, Ticket[].class);
			
			Ticket[] body = forEntity.getBody();
			List<Ticket> tickets = Arrays.asList(body);
			
			return tickets;
		}
}

package com.example.demo.mohit.services;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.mohit.models.Passenger;
import com.example.demo.mohit.models.Ticket;

import reactor.core.publisher.Mono;


@Service
public class MakeMyTripService {

	
	// consumer Logic
	 //body to send data in body
    //retrive to get response
    //bodyToMono map to java Ticket class
	public Mono<Ticket> bookTicket(Passenger p) {

		String apiUrl = "http://13.127.151.246:8081/ticket";
		
		WebClient webClient = WebClient.create();
		
	  	Mono<Ticket> bodyToMono = webClient.post()
								  		   .uri(apiUrl)
								  		   .body(BodyInserters.fromValue(p))
								  		   .retrieve()
								  		   .bodyToMono(Ticket.class);
	 
		return bodyToMono;
	}

	public Mono<Ticket[]> getAllTickets() {

		String apiUrl = "http://13.127.151.246:8081/tickets";
		
		WebClient webClient = WebClient.create();
		
		Mono<Ticket[]> bodyToMono = webClient.get()
											 .uri(apiUrl)
											 .retrieve()
											 .bodyToMono(Ticket[].class);
		return bodyToMono;
	}
}

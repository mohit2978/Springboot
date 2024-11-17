package com.example.demo.mohit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mohit.models.Passenger;
import com.example.demo.mohit.models.Ticket;
import com.example.demo.mohit.services.MakeMyTripService;

import reactor.core.publisher.Mono;



@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		Mono<Ticket[]> allTickets = service.getAllTickets();
		
		model.addAttribute("tickets", allTickets);
		
		return "index";
		}

	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		Mono<Ticket> bookTicket = service.bookTicket(p);
		
		model.addAttribute("msg", "Your Ticket Booked");
		model.addAttribute("ticket", bookTicket);
		return "bookTicket";
	}

	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passenger());
		model.addAttribute("ticket", new Ticket());
		
		return "bookTicket";
	}

}

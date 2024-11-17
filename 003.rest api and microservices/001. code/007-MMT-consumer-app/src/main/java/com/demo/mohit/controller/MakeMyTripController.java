package com.demo.mohit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.mohit.models.Passenger;
import com.demo.mohit.models.Ticket;
import com.demo.mohit.services.MakeMyTripService;


@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Ticket> alltickets = service.getAllTickets();
		
		model.addAttribute("tickets", alltickets);
		
		return "index";
		}

	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		Ticket bookTicket = service.bokticket(p);
		model.addAttribute("msg", "Your Ticket Booked, ID : "+ bookTicket.getTicketNum());
		return "bookTicket";
	}

	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passenger());
		return "bookTicket";
	}

}

package com.demo.mohit.service;

import java.util.Collection;

import com.demo.mohit.models.Passenger;
import com.demo.mohit.models.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger p);
	
	public Collection<Ticket> getAllTickets();
}

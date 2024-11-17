package com.demo.mohit.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.demo.mohit.models.Passenger;
import com.demo.mohit.models.Ticket;

@Service
public class TicketServiceImpl implements TicketService{

	Map<Integer, Ticket> db = new HashMap<>();
	
	@Override
	public Ticket bookTicket(Passenger p) {
		
		Ticket t = new Ticket();
		
		Random r = new Random();
		
		int id = r.nextInt(6);
		
		t.setTicketNum(id);
		
		BeanUtils.copyProperties(p, t);
		t.setStatus("CONFIRMED");
		db.put(id, t);
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		return db.values();
	}

}

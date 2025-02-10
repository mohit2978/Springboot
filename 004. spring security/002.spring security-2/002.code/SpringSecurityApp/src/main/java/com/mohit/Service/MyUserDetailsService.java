package com.mohit.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mohit.Entity.Customer;
import com.mohit.Repo.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private CustomerRepo crepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer c = crepo.findByUname(username);
		return new User(c.getUname(), c.getPwd(), Collections.emptyList());
	}
}

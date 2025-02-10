package com.mohit.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohit.Entity.Customer;



@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

	public Customer findByUname(String cuname);

}
package com.mohit.Repository;
import com.mohit.Hash.Customer;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
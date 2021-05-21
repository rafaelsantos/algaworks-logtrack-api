package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.domain.model.Customer;
import com.github.rafaelsantos.logtrack.domain.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public Collection<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> find(@PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		
		if(customer.isPresent())
			return ResponseEntity.ok(customer.get());
		
		return ResponseEntity.notFound().build();
	}
}

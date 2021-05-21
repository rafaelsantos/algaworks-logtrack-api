package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

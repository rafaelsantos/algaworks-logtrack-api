package com.github.rafaelsantos.logtrack.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.model.Customer;

@RestController
public class CustomerController {
	
	@GetMapping("/customers")
	public Collection<Customer> findAll() {
		//Using var: java11
		var customer = new Customer(1L, "Johnny", "johnny.laurence@gmail.com", "45 9999-9999");
		var customer2 = new Customer(2L, "Gary", "gary.byrnes@gmail.com", "75 5678-9999");
		
		return Arrays.asList(customer, customer2);
	}
}

package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.domain.model.Customer;
import com.github.rafaelsantos.logtrack.domain.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public Collection<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> find(@PathVariable Long id) {
		return customerRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}

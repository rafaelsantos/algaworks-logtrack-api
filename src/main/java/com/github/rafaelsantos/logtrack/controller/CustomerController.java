package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.domain.model.Customer;
import com.github.rafaelsantos.logtrack.domain.repository.CustomerRepository;
import com.github.rafaelsantos.logtrack.domain.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Long id, @RequestBody Customer customer) {
		if (!customerRepository.existsById(id))
			return ResponseEntity.notFound().build();
		
		customer.setId(id);
		return ResponseEntity.ok(customerService.save(customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		if (!customerRepository.existsById(id))
			return ResponseEntity.notFound().build();
		
		customerService.remove(id);
		return ResponseEntity.noContent().build();
	}
}

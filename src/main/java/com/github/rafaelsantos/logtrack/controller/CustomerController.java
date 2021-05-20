package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.model.Customer;

@RestController
public class CustomerController {
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping("/customers")
	public Collection<Customer> findAll() {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}
}

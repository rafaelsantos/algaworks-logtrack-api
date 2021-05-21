package com.github.rafaelsantos.logtrack.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.rafaelsantos.logtrack.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Collection<Customer> findByName(String name);
	Collection<Customer> findByNameContaining(String name);
}

package com.github.rafaelsantos.logtrack.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.rafaelsantos.logtrack.domain.exception.BusinessException;
import com.github.rafaelsantos.logtrack.domain.model.Customer;
import com.github.rafaelsantos.logtrack.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer save(Customer customer) {
		boolean exists = customerRepository.findByMail(customer.getMail())
				.stream().anyMatch(c -> !c.equals(customer));
		
		if (exists)
			throw new BusinessException("Mail is already in use");
		
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void remove(Long id) {
		customerRepository.deleteById(id);
	}
	
	public Customer search(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Customer not found"));
	}
}

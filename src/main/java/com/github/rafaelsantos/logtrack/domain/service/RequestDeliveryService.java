package com.github.rafaelsantos.logtrack.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.rafaelsantos.logtrack.domain.model.Customer;
import com.github.rafaelsantos.logtrack.domain.model.Delivery;
import com.github.rafaelsantos.logtrack.domain.model.DeliveryStatus;
import com.github.rafaelsantos.logtrack.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RequestDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	private CustomerService customerService;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		Customer customer = customerService.search(delivery.getCustomer().getId());
		
		delivery.setCustomer(customer);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrderDate(LocalDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
}


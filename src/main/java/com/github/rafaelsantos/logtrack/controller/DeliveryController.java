package com.github.rafaelsantos.logtrack.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaelsantos.logtrack.domain.model.Delivery;
import com.github.rafaelsantos.logtrack.domain.repository.DeliveryRepository;
import com.github.rafaelsantos.logtrack.domain.service.RequestDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private RequestDeliveryService requestDeliveryService;
	private DeliveryRepository deliveryRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@Valid @RequestBody Delivery delivery) {
		return requestDeliveryService.request(delivery);
	}
	
	@GetMapping
	public Collection<Delivery> findAll() {
		return deliveryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Delivery> find(@PathVariable Long id) {
		return deliveryRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		
	}
}

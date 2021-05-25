package com.github.rafaelsantos.logtrack.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.rafaelsantos.logtrack.domain.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customer")
public class Customer {
	
	@EqualsAndHashCode.Include
	@NotNull(groups = ValidationGroups.CustomerId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String name;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String mail;
	
	@NotBlank
	@Size(max = 20)
	private String phone;
	
	public Customer() {}
	
	public Customer(long id, String name, String mail, String phone) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
	}
}

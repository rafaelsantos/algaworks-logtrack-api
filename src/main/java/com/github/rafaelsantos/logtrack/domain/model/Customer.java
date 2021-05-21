package com.github.rafaelsantos.logtrack.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String mail;
	private String phone;
	
	public Customer() {}
	
	public Customer(long id, String name, String mail, String phone) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
	}
}

package com.github.rafaelsantos.logtrack.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	
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

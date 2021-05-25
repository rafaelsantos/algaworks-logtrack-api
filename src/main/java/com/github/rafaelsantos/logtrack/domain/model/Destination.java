package com.github.rafaelsantos.logtrack.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destination {
	
	@Column(name = "destination_name")
	private String name;
	
	@Column(name = "destination_address")
	private String address;
	
	@Column(name = "destination_number")
	private String number;
	
	@Column(name = "destination_complement")
	private String complement;
	
	@Column(name = "destination_district")
	private String district;
}

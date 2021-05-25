package com.github.rafaelsantos.logtrack.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destination {
	
	@NotBlank
	@Column(name = "destination_name")
	private String name;
	
	@NotBlank
	@Column(name = "destination_address")
	private String address;
	
	@NotBlank
	@Column(name = "destination_number")
	private String number;
	
	@NotBlank
	@Column(name = "destination_complement")
	private String complement;
	
	@NotBlank
	@Column(name = "destination_district")
	private String district;
}

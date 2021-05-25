package com.github.rafaelsantos.logtrack.domain.model;

import java.math.BigDecimal;

import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import com.github.rafaelsantos.logtrack.domain.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Valid
	@NotNull
	@Embedded
	private Destination destination;
	
	@NotNull
	private BigDecimal tax;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime orderDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime endDate;
}

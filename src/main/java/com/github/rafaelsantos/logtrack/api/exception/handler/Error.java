package com.github.rafaelsantos.logtrack.api.exception.handler;

import java.time.LocalDateTime;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
	private Integer status;
	private LocalDateTime date;
	private String title;
	
	private Collection<Field> fields;
	
	@AllArgsConstructor
	@Getter
	public static class Field {
		private String name;
		private String message;
	}
}
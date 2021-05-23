package com.github.rafaelsantos.logtrack.api.exception.handler;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Collection<Error.Field> fields = new ArrayList<>();
		
		exception.getBindingResult().getAllErrors().stream().forEach(error -> {
			String name = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			fields.add(new Error.Field(name, message));
		});
		
		Error error = new Error();
		error.setStatus(status.value());
		error.setDate(LocalDateTime.now());
		error.setFields(fields);
		
		return handleExceptionInternal(exception, error, headers, status, request);
	}
}

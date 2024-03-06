package com.patron.mx.puntodeventa.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.patron.mx.puntodeventa.dtos.ErrorDto;

public class NotFoundException extends GlobalExceptionHandler{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String code, int responseCode, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	public NotFoundException(String code, int responseCode, String message,ErrorDto data) {
		super(code, HttpStatus.NOT_FOUND.value(), message,Arrays.asList(data));
	}

}

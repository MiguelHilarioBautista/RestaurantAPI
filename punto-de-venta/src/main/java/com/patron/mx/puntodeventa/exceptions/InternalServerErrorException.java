package com.patron.mx.puntodeventa.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.patron.mx.puntodeventa.dtos.ErrorDto;

public class InternalServerErrorException extends GlobalExceptionHandler{
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String code, int responseCode, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	public InternalServerErrorException(String code, int responseCode, String message,ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message,Arrays.asList(data));
	}
}

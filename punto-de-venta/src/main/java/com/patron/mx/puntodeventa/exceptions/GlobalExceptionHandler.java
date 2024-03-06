package com.patron.mx.puntodeventa.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.patron.mx.puntodeventa.dtos.ErrorDto;

import lombok.Getter;

@Getter
public class GlobalExceptionHandler extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final String code;
	private final int responseCode;
	private final List<ErrorDto> errorList=new ArrayList<>();
	
	public GlobalExceptionHandler(String code, int responseCode,String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	public GlobalExceptionHandler(String code, int responseCode,String message,List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}
	

}

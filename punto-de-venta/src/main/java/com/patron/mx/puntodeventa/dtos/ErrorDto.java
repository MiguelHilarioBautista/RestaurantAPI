package com.patron.mx.puntodeventa.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String value;
}

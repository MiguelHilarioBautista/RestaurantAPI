package com.patron.mx.puntodeventa.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnSaveAndUpdateRest {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;	
	
	@JsonProperty("Restaurant")
	private int restaurantId;
}

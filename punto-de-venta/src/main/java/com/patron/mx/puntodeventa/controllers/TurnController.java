package com.patron.mx.puntodeventa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patron.mx.puntodeventa.entities.Turn;
import com.patron.mx.puntodeventa.services.TurnService;

@RestController
@RequestMapping(path = "/turn")
public class TurnController {
	
	private TurnService turnService;
	
	@Autowired
	public TurnController(TurnService turnService) {
		this.turnService=turnService;
	}
	
	@PostMapping("/saveTurn")
	String saveTurn(@RequestBody Turn turn) {
		return turnService.saveTurn(turn);
	}
}

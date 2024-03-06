package com.patron.mx.puntodeventa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patron.mx.puntodeventa.SingleResponse;
import com.patron.mx.puntodeventa.exceptions.GlobalExceptionHandler;
import com.patron.mx.puntodeventa.jsons.TurnAndRestauranRest;
import com.patron.mx.puntodeventa.jsons.TurnSaveAndUpdateRest;
import com.patron.mx.puntodeventa.services.TurnService;

@RestController
@RequestMapping(path = "/turn")
public class TurnController {

	private TurnService turnService;

	@Autowired
	public TurnController(TurnService turnService) {
		this.turnService = turnService;
	}

	@PostMapping("/saveTurn")
	public SingleResponse<String> saveTurn(@RequestBody TurnSaveAndUpdateRest turn) throws GlobalExceptionHandler {
		return new SingleResponse<>("Success", String.valueOf(HttpStatus.OK), "Ok",turnService.saveTurn(turn)); 
	}

	@GetMapping("/getAllTurn")
	public SingleResponse<List<TurnAndRestauranRest>> getAllTurn() throws GlobalExceptionHandler {
		List<TurnAndRestauranRest> turns = turnService.getAllTurns();
		return new SingleResponse<>("Success", String.valueOf(HttpStatus.OK), "Ok",turns); 
	}
	@GetMapping("/getTurnById")
	public SingleResponse<TurnAndRestauranRest> getTurnById(Long id) throws GlobalExceptionHandler {
		return new SingleResponse<>("Success", String.valueOf(HttpStatus.OK), "Ok", turnService.getTurnById(id));
	}

}

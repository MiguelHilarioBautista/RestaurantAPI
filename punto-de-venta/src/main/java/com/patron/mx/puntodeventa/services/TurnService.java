package com.patron.mx.puntodeventa.services;

import java.util.List;

import com.patron.mx.puntodeventa.exceptions.GlobalExceptionHandler;
import com.patron.mx.puntodeventa.jsons.TurnAndRestauranRest;
import com.patron.mx.puntodeventa.jsons.TurnSaveAndUpdateRest;

public interface TurnService {
	
	String saveTurn(TurnSaveAndUpdateRest turn) throws GlobalExceptionHandler;
	List<TurnAndRestauranRest> getAllTurns() throws GlobalExceptionHandler;
	String updateTurn(TurnSaveAndUpdateRest turn) throws GlobalExceptionHandler;
	String deleteTurn(int id) throws GlobalExceptionHandler;
	TurnAndRestauranRest getTurnById(Long id)throws GlobalExceptionHandler;
}

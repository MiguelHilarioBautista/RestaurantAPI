package com.patron.mx.puntodeventa.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patron.mx.puntodeventa.entities.Turn;
import com.patron.mx.puntodeventa.exceptions.NotFoundException;
import com.patron.mx.puntodeventa.exceptions.GlobalExceptionHandler;
import com.patron.mx.puntodeventa.jsons.RestaurantRest;
import com.patron.mx.puntodeventa.jsons.TurnAndRestauranRest;
import com.patron.mx.puntodeventa.jsons.TurnSaveAndUpdateRest;
import com.patron.mx.puntodeventa.repositories.TurnRepository;
import com.patron.mx.puntodeventa.services.TurnService;

@Service
public class TurnServiceImpl implements TurnService {
	private static final Logger logger = LoggerFactory.getLogger(TurnServiceImpl.class);

	public static final ModelMapper MODEL_MAPPER = new ModelMapper();

	private TurnRepository turnRepository;

	@Autowired
	public TurnServiceImpl(TurnRepository turnRepository) {
		this.turnRepository = turnRepository;
	}

	public String saveTurn(TurnSaveAndUpdateRest turnRest) throws GlobalExceptionHandler {
		try {
			Turn turn = MODEL_MAPPER.map(turnRest, Turn.class);
			turnRepository.save(turn);
			logger.info("Se guardó correctamente");
			return "Se guardó correctamente";
		} catch (Exception e) {
			logger.error("Error al guardar " + e.getMessage());
			return "Error al guardar " + e.getMessage();
		}

	}

	public List<TurnAndRestauranRest> getAllTurns() throws GlobalExceptionHandler {
		List<Turn> turns = turnRepository.getAllTurn().orElseThrow(() -> new NotFoundException("SNOT-404-1", 0, "TURN_NOT_FOUND"));
		return turns.stream().map(turn -> {
			TurnAndRestauranRest turnRest = MODEL_MAPPER.map(turn, TurnAndRestauranRest.class);
			turnRest.setRestaurantId(MODEL_MAPPER.map(turn.getRestaurant(), RestaurantRest.class));
			return turnRest;
		}).collect(Collectors.toList());
	}

	@Override
	public String updateTurn(TurnSaveAndUpdateRest turn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTurn(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TurnAndRestauranRest getTurnById(Long id) throws GlobalExceptionHandler {
		Turn turn = getTurnSerById(id);
		return mapTurnAndRestaurant(turn);
	}

	private Turn getTurnSerById(Long id) throws GlobalExceptionHandler {
		return turnRepository.findById(id).orElseThrow(() -> new NotFoundException("SNOT-404-1", 0, "TURN_NOT_FOUND"));
	}

	private TurnAndRestauranRest mapTurnAndRestaurant(Turn turn) {
		TurnAndRestauranRest turnRest = MODEL_MAPPER.map(turn, TurnAndRestauranRest.class);
		turnRest.setRestaurantId(MODEL_MAPPER.map(turn.getRestaurant(), RestaurantRest.class));
		return turnRest;
	}

}

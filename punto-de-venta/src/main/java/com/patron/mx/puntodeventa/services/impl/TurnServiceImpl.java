package com.patron.mx.puntodeventa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patron.mx.puntodeventa.entities.Turn;
import com.patron.mx.puntodeventa.repositories.TurnRepository;
import com.patron.mx.puntodeventa.services.TurnService;

@Service
public class TurnServiceImpl implements TurnService{
	
	private TurnRepository turnRepository;
	
	@Autowired
	public TurnServiceImpl(TurnRepository turnRepository) {
		this.turnRepository=turnRepository;
	}

	@Override
	public String saveTurn(Turn turn) {
		try {
			turnRepository.save(turn);
			return "Se guardó correctamente";
		} catch (Exception e) {
			return "Error al guardar "+ e.getMessage();
		}
		
	}
	
	
}

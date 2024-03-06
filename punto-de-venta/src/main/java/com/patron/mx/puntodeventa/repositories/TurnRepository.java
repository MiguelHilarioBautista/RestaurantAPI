package com.patron.mx.puntodeventa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patron.mx.puntodeventa.entities.Turn;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long>{
	@Query("SELECT tu FROM Turn tu JOIN FETCH tu.restaurant WHERE tu.turnId=?1 ORDER BY tu.turnId DESC")
	Optional<Turn> findById(Long id);
	
	@Query("SELECT tu FROM Turn tu JOIN FETCH tu.restaurant ORDER BY tu.turnId DESC")
	Optional<List<Turn>> getAllTurn();
}

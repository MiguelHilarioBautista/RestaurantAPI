package com.patron.mx.puntodeventa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patron.mx.puntodeventa.entities.Turn;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long>{

	Optional<Turn> findById(Long id);
	
	@Query("SELECT TU FROM Turn TU")
	List<Turn> getAllTurn();
}

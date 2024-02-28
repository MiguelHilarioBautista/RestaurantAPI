package com.patron.mx.puntodeventa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patron.mx.puntodeventa.entities.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	Optional<Board> findById(Long id);
	
	@Query("SELECT BO FROM Board BO")
	List<Board> getAllBoards(); 
}

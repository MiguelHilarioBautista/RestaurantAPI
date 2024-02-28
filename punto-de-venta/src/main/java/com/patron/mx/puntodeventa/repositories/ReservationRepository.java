package com.patron.mx.puntodeventa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.patron.mx.puntodeventa.entities.Reservation;

import jakarta.transaction.Transactional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Optional<Reservation> findById(Long id);

	@Modifying
	@Transactional
	Optional<Reservation> deleteByLocator(String locator);
	
	//Optional<Reservation> findByTurnAndRestaurantId(String turn,Long restaurantId);
}

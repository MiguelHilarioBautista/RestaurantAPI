package com.patron.mx.puntodeventa.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservation", schema = "public")
@Data
public class Reservation {
	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int idReservation;
	
	@Column(name = "locator")
	private String locator;
	
	@Column(name = "person")
	private int person;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "turn")
	private String turn;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}

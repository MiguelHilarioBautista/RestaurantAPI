package com.patron.mx.puntodeventa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "board", schema = "public")
@Data
public class Board {
	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoard;

    @Column(name = "capacity")
    private int capacity;
    
    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "idRestaurant")
    private Restaurant restaurant;
	
}

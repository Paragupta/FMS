package com.pjsoft.fms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime departureTime;

	@Column(nullable = false)
	private LocalDateTime arrivalTime;

	@ManyToOne
	@JoinColumn(name = "departure_airport_id", nullable = false)
	private Airport departureAirport;

	@ManyToOne
	@JoinColumn(name = "arrival_airport_id", nullable = false)
	private Airport arrivalAirport;
}

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
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime bookingDate;

	@ManyToOne
	@JoinColumn(name = "passenger_id", nullable = false)
	private Passenger passenger;

	@ManyToOne
	@JoinColumn(name = "scheduled_flight_id", nullable = false)
	private ScheduledFlight scheduledFlight;

	@Column(nullable = false)
	private String status;

}

package com.pjsoft.fms.pojo.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleDTO {

	private Long id;

	private LocalDateTime departureTime;

	private LocalDateTime arrivalTime;

	private AirportDTO departureAirport;

	private AirportDTO arrivalAirport;
}

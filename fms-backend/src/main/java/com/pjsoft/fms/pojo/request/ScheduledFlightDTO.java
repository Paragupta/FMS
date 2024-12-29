package com.pjsoft.fms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduledFlightDTO {

	private Long id;

	private FlightDTO flight;

	private ScheduleDTO schedule;

	private int availableSeats;

}

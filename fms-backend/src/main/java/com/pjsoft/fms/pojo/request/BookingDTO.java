package com.pjsoft.fms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {

	private Long id;

	private String bookingDate;

	private PassengerDTO passenger;

	private ScheduledFlightDTO scheduledFlight;

	private String status;
}

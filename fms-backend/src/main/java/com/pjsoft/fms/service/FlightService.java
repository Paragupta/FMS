package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.pojo.request.FlightDTO;

public interface FlightService {
	public List<Flight> getAllFlights();

	public FlightDTO getFlightById(Long id);

	public Flight saveFlight(Flight flight);

	public void deleteFlight(Long id);
}

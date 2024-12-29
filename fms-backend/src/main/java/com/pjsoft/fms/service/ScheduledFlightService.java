package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;

public interface ScheduledFlightService {
	public List<ScheduledFlight> getAllScheduledFlights();

	public ScheduledFlightDTO getScheduledFlightById(Long id);

	public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledFlight);

	public void deleteScheduledFlight(Long id);
}

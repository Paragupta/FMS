package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.mapper.ScheduledFlightMapper;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;
import com.pjsoft.fms.repository.ScheduledFlightRepository;
import com.pjsoft.fms.service.ScheduledFlightService;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {
	@Autowired
	private ScheduledFlightRepository scheduledFlightRepository;
	@Autowired
	private ScheduledFlightMapper scheduledFlightMapper;

	@Override
	public List<ScheduledFlight> getAllScheduledFlights() {
		return scheduledFlightRepository.findAll();
	}

	@Override
	public ScheduledFlightDTO getScheduledFlightById(Long id) {
		return scheduledFlightMapper.entityToDtoMapper(scheduledFlightRepository.findById(id).orElse(null));
	}

	@Override
	public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledFlight) {
		return scheduledFlightRepository.save(scheduledFlight);
	}

	@Override
	public void deleteScheduledFlight(Long id) {
		scheduledFlightRepository.deleteById(id);
	}
}

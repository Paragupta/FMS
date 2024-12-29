package com.pjsoft.fms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pjsoft.fms.config.EmailBean;
import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.FlightMapper;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.pojo.request.FlightDTO;
import com.pjsoft.fms.repository.FlightRepository;
import com.pjsoft.fms.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightMapper flightMapper;

	@Autowired
	@Qualifier("primaryBean")
	private EmailBean emailBean;

	private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, readOnly = false, rollbackFor = {
			ResourceNotFoundException.class })
	@Override
	public FlightDTO getFlightById(Long id) {
		logger.debug("inside getFlightById");
		return flightMapper.entityToDtoMapper(flightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id)));
	}

	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public void deleteFlight(Long id) {
		flightRepository.deleteById(id);
	}
}

package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.config.EmailBean;
import com.pjsoft.fms.mapper.AirportMapper;
import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.pojo.request.AirportDTO;
import com.pjsoft.fms.repository.AirportRepository;
import com.pjsoft.fms.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private AirportMapper airportMapper;

	@Autowired
	@Qualifier("primaryBean")
	private EmailBean emailBean;

	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@Override
	public AirportDTO getAirportById(Long id) {
		return airportMapper.entityToDtoMapper(airportRepository.findById(id).orElse(null));
	}

	@Override
	public Airport saveAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public void deleteAirport(Long id) {
		airportRepository.deleteById(id);
	}
}

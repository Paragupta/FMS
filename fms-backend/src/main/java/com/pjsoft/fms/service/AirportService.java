package com.pjsoft.fms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.pojo.request.AirportDTO;

public interface AirportService {
	public List<Airport> getAllAirports();

	public AirportDTO getAirportById(Long id);

	public Airport saveAirport(Airport airport);

	public void deleteAirport(Long id);

}

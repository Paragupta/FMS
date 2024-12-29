package com.pjsoft.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.pojo.request.AirportDTO;
import com.pjsoft.fms.service.AirportService;
import com.pjsoft.fms.service.impl.AirportServiceImpl;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

	private final AirportService airportService;

	public AirportController(@Autowired AirportServiceImpl airportService) {
		this.airportService = airportService;
	}

	@GetMapping
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
		return ResponseEntity.ok(airportService.getAirportById(id));
	}

	@PostMapping
	public Airport createAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}

	@PutMapping("/{id}")
	public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
		airport.setId(id);
		return airportService.saveAirport(airport);
	}

	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable Long id) {
		airportService.deleteAirport(id);
	}
}

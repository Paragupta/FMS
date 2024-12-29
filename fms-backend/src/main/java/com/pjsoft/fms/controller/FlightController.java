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

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.pojo.request.FlightDTO;
import com.pjsoft.fms.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
	@Autowired
	private FlightService flightService;

	@GetMapping
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
		return ResponseEntity.ok(flightService.getFlightById(id));
	}

	@PostMapping
	public Flight createFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}

	@PutMapping("/{id}")
	public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
		flight.setId(id);
		return flightService.saveFlight(flight);
	}

	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable Long id) {
		flightService.deleteFlight(id);
	}
}

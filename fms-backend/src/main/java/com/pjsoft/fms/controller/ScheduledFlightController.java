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

import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;
import com.pjsoft.fms.service.ScheduledFlightService;

@RestController
@RequestMapping("/api/scheduledFlights")
public class ScheduledFlightController {
	@Autowired
	private ScheduledFlightService scheduledFlightService;

	@GetMapping
	public List<ScheduledFlight> getAllScheduledFlights() {
		return scheduledFlightService.getAllScheduledFlights();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScheduledFlightDTO> getScheduledFlightById(@PathVariable Long id) {
		return ResponseEntity.ok(scheduledFlightService.getScheduledFlightById(id));
	}

	@PostMapping
	public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		return scheduledFlightService.saveScheduledFlight(scheduledFlight);
	}

	@PutMapping("/{id}")
	public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight) {
		scheduledFlight.setId(id);
		return scheduledFlightService.saveScheduledFlight(scheduledFlight);
	}

	@DeleteMapping("/{id}")
	public void deleteScheduledFlight(@PathVariable Long id) {
		scheduledFlightService.deleteScheduledFlight(id);
	}
}

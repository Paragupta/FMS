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

import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.pojo.request.PassengerDTO;
import com.pjsoft.fms.service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;

	@GetMapping
	public List<Passenger> getAllPassengers() {
		return passengerService.getAllPassengers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long id) {
		return ResponseEntity.ok(passengerService.getPassengerById(id));
	}

	@PostMapping
	public Passenger createPassenger(@RequestBody Passenger passenger) {
		return passengerService.savePassenger(passenger);
	}

	@PutMapping("/{id}")
	public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
		passenger.setId(id);
		return passengerService.savePassenger(passenger);
	}

	@DeleteMapping("/{id}")
	public void deletePassenger(@PathVariable Long id) {
		passengerService.deletePassenger(id);
	}
}

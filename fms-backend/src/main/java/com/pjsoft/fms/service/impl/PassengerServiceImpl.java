package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.mapper.PassengerMapper;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.pojo.request.PassengerDTO;
import com.pjsoft.fms.repository.PassengerRepository;
import com.pjsoft.fms.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private PassengerMapper passengerMapper;

	public List<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}

	public PassengerDTO getPassengerById(Long id) {
		return passengerMapper.entityToDtoMapper(passengerRepository.findById(id).orElse(null));
	}

	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	public void deletePassenger(Long id) {
		passengerRepository.deleteById(id);
	}
}

package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.pojo.request.PassengerDTO;

public interface PassengerService {
	public List<Passenger> getAllPassengers();

	public PassengerDTO getPassengerById(Long id);

	public Passenger savePassenger(Passenger passenger);

	public void deletePassenger(Long id);
}

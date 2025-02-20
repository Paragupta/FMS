package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pjsoft.fms.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}

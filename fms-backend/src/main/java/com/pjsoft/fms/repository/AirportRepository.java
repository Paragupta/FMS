package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}

package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.FlightDTO;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;

@Mapper(componentModel = "spring", uses = { ScheduleMapper.class, AirportMapper.class })
public interface FlightMapper {

	@Mapping(target = "scheduledFlightList.flight", ignore = true)
	FlightDTO entityToDtoMapper(Flight entity);

	@Mapping(target = "scheduledFlightList.flight", ignore = true)
	Flight dtoToEntityMapper(FlightDTO dto);
	
	 // Add mapping for ScheduledFlightDTO to ScheduledFlight, ignoring flight field
    @Mapping(target = "flight", ignore = true)
    ScheduledFlight scheduledFlightDTOToScheduledFlight(ScheduledFlightDTO scheduledFlightDTO);

    @Mapping(target = "flight", ignore = true)
    ScheduledFlightDTO scheduledFlightToScheduledFlightDTO(ScheduledFlight scheduledFlight);
}

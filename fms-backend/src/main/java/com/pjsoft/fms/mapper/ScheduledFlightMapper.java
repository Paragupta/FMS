package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;

@Mapper(componentModel = "spring", uses = { ScheduleMapper.class })
public interface ScheduledFlightMapper {

	@Mapping(target = "flight.scheduledFlightList", ignore = true)
	ScheduledFlightDTO entityToDtoMapper(ScheduledFlight entity);

	@Mapping(target = "flight.scheduledFlightList", ignore = true)
	ScheduledFlight dtoToEntityMapper(ScheduledFlightDTO dto);

}

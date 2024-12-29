package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.ScheduleDTO;

@Mapper(componentModel = "spring", uses = { AirportMapper.class })
public interface ScheduleMapper {

	ScheduleDTO entityToDtoMapper(Schedule entity);

	Schedule dtoToEntityMapper(ScheduleDTO dto);
}

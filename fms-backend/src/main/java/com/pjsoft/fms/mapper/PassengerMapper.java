package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.pojo.request.PassengerDTO;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

	PassengerDTO entityToDtoMapper(Passenger entity);

	Passenger dtoToEntityMapper(PassengerDTO dto);
}

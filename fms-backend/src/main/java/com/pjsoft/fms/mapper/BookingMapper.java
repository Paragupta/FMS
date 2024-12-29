package com.pjsoft.fms.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.BookingDTO;

@Mapper(componentModel = "spring", uses = { PassengerMapper.class, ScheduledFlightMapper.class })
public interface BookingMapper {

	@Mapping(target = "bookingDate", expression = "java(booking.getBookingDate() != null ? booking.getBookingDate().format(java.time.format.DateTimeFormatter.ofPattern(\"dd-MM-yy\")) : null)")
	BookingDTO entityToDtoMapper(Booking booking);

	@Mapping(source = "status", target = "status")
	Booking dtoToEntityMapper(BookingDTO dto);

	@AfterMapping
	default void afterMapping(@MappingTarget BookingDTO dto, Booking entity) {
		dto.setStatus(entity.getStatus().toUpperCase());
	}
}

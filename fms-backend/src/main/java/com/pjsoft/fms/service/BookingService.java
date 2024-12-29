package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.exception.RetryableException;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.BookingDTO;

public interface BookingService {
	public List<Booking> getAllBookings();

	public BookingDTO getBookingById(Long id) throws RetryableException;

	public Booking saveBooking(BookingDTO booking);

	public void deleteBooking(Long id);

}

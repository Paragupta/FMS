package com.pjsoft.fms.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjsoft.fms.config.EmailBean;
import com.pjsoft.fms.exception.RetryableException;
import com.pjsoft.fms.mapper.BookingMapper;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.BookingDTO;
import com.pjsoft.fms.repository.BookingRepository;
import com.pjsoft.fms.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingMapper bookingMapper;

	@Autowired
	@Qualifier("secondaryBean")
	private EmailBean emailBean;

	static int counter = 0;

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Retryable(value = { RetryableException.class }, maxAttempts = 4, backoff = @Backoff(delay = 2000, multiplier = 1))
	@Override
	public BookingDTO getBookingById(Long id) throws RetryableException {
		System.out.println(LocalTime.now() + " - Attempting...");

		return bookingMapper.entityToDtoMapper(
				bookingRepository.findById(id).orElseThrow(() -> new RetryableException("Exception " + id)));
	}

	@Recover
	public BookingDTO recover(RetryableException e, Long id) {
		System.out.println(LocalTime.now() + " - Recovering from exception: " + e.getMessage());
		// Implement your recovery logic here, for example:
		// Log the failure, notify an administrator, return a default value, etc.
		// For this example, you can return a default BookingDTO or handle it as needed.
		return new BookingDTO();
	}

	@Transactional(readOnly = true)
	@Override
	public Booking saveBooking(BookingDTO booking) {
		return bookingRepository.save(bookingMapper.dtoToEntityMapper(booking));

	}

	@Override
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}

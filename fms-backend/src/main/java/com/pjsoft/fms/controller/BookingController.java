package com.pjsoft.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.config.EmailBean;
import com.pjsoft.fms.exception.RetryableException;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.BookingDTO;
import com.pjsoft.fms.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@Autowired
	@Qualifier("secondaryBean")
	private EmailBean emailBean;

	@GetMapping
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) throws RetryableException {
		return ResponseEntity.ok(bookingService.getBookingById(id));
	}

	@PostMapping
	public Booking createBooking(@RequestBody BookingDTO booking) {
		return bookingService.saveBooking(booking);
	}

	@PutMapping("/{id}")
	public Booking updateBooking(@PathVariable Long id, @RequestBody BookingDTO booking) {
		booking.setId(id);
		return bookingService.saveBooking(booking);
	}

	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
	}
}

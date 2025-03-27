package com.example.mesto.service;

import com.example.mesto.entity.Booking;
import com.example.mesto.entity.User;
import com.example.mesto.exception.ResourceNotFoundException;
import com.example.mesto.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }

    public List<Booking> getBookingsByRenter(User renter) {
        return bookingRepository.findByRenter(renter);
    }

    public List<Booking> getBookingsByLandlord(User landlord) {
        return bookingRepository.findByProperty_Landlord(landlord);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = getBookingById(id);
        booking.setStatus(bookingDetails.getStatus());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

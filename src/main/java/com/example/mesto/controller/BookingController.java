package com.example.mesto.controller;

import com.example.mesto.entity.Booking;
import com.example.mesto.entity.BookingStatus;
import com.example.mesto.entity.Property;
import com.example.mesto.entity.User;
import com.example.mesto.model.BookingDTO;
import com.example.mesto.service.BookingService;
import com.example.mesto.service.PropertyService;
import com.example.mesto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final PropertyService propertyService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        Property property = propertyService.getPropertyById(bookingDTO.getPropertyId());
        User renter = userService.getUserById(bookingDTO.getRenterId());
        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setRenter(renter);
        booking.setStartDateTime(bookingDTO.getStartDateTime());
        booking.setEndDateTime(bookingDTO.getEndDateTime());
        booking.setStatus(BookingStatus.PENDING);
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping("/renter/{renterId}")
    public ResponseEntity<List<Booking>> getBookingsByRenter(@PathVariable Long renterId) {
        User renter = userService.getUserById(renterId);
        return ResponseEntity.ok(bookingService.getBookingsByRenter(renter));
    }

    @GetMapping("/landlord/{landlordId}")
    public ResponseEntity<List<Booking>> getBookingsByLandlord(@PathVariable Long landlordId) {
        User landlord = userService.getUserById(landlordId);
        return ResponseEntity.ok(bookingService.getBookingsByLandlord(landlord));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id, @RequestParam String status) {
        Booking booking = bookingService.getBookingById(id);
        booking.setStatus(BookingStatus.valueOf(status.toUpperCase()));
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}

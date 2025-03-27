package com.example.mesto.repository;

import com.example.mesto.entity.Booking;
import com.example.mesto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRenter(User renter);
    List<Booking> findByProperty_Landlord(User landlord);
    List<Booking> findByStatus(String status);
}

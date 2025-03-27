package com.example.mesto.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long propertyId;
    private Long renterId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}

package com.example.mesto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String address;
    private int capacity;
    private String type;
    private String availabilityHours;
    private String features;

    private String contactName;
    private String contactPhone;
    private String contactEmail;

    private double pricePerHour;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private User landlord;
}

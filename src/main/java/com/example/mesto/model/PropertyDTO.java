package com.example.mesto.model;

import lombok.Data;

@Data
public class PropertyDTO {
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
}

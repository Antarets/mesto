package com.example.mesto.model;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String role; // LANDLORD or RENTER
    private String institutionName;
    private String institutionInn;
    private String institutionAddress;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
}

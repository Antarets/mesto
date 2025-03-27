package com.example.mesto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    private String institutionName;
    private String institutionInn;
    private String institutionAddress;

    private String contactName;
    private String contactPhone;
    private String contactEmail;
}

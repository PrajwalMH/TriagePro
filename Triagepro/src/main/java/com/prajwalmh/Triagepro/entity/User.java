package com.prajwalmh.Triagepro.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String role; // PATIENT / DOCTOR / ADMIN
    private String passwordHash;
}

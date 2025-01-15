package com.codej.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
 @Entity
@Table(name = "patient")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID idPatient;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", length = 9)
    private String phone;


}

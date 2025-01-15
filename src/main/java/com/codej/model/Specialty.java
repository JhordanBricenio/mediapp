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
@Table(name = "specialty")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idSpecialty;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "description",nullable = false, length = 150)
    private String description;
}

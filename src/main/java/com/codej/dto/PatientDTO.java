package com.codej.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private UUID idPatient;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String email;
    private String phone;
}

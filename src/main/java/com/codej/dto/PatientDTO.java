package com.codej.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {


    private UUID idPatient;
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    @Size(min = 8, max = 8)
    private String dni;

    @Size(max = 150)
    private String address;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "[0-9]{9}")
    private String phone;
}

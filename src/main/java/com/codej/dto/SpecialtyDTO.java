package com.codej.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDTO {

    private UUID idSpecialty;
    @NotNull
    private String nameSpecialty;

    @NotNull
    private String descriptionSpecialty;
}

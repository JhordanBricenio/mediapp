package com.codej.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicDTO {

    private UUID idMedic;
    @NotNull
    private Integer idSpecialty;
    @NotNull
    @Size(min = 3, max = 50)
    private String primaryName;

    @NotNull
    @Size(min = 3, max = 50)
    private String secondaryName;

    @NotNull
    @Size(min = 3, max = 12)
    private String cmp;

    @NotNull
    private String photo;
}

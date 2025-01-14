package com.codej.controller;

import com.codej.model.Patient;
import com.codej.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;
    @GetMapping
    public Patient getPatients() {
        return new Patient(1L, "John Doe");
    }
}

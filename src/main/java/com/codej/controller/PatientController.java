package com.codej.controller;

import com.codej.model.Patient;
import com.codej.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;
    @GetMapping
    public List<Patient> getPatients() throws Exception {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable UUID id) throws Exception {
        return patientService.findById(id);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) throws Exception {
        return patientService.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable UUID id) throws Exception {
        return patientService.update(patient, id);
    }

    @DeleteMapping("/{id}")
    public  void deletePatient(@PathVariable UUID id) throws Exception {
        patientService.delete(id);
    }




}

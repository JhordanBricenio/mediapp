package com.codej.controller;

import com.codej.dto.PatientDTO;
import com.codej.model.Patient;
import com.codej.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getPatients() throws Exception {
        List<PatientDTO> patients = patientService.findAll().stream().map(patient-> modelMapper.map(patient, PatientDTO.class)).toList();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable UUID id) throws Exception {
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(modelMapper.map(patient, PatientDTO.class));
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) throws Exception {
        Patient savedPatient = patientService.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPatient.getIdPatient()).toUri();
        return ResponseEntity.created(location).body(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable UUID id) throws Exception {
        Patient savedPatient = patientService.save(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePatient(@PathVariable UUID id) throws Exception {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

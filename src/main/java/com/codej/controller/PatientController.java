package com.codej.controller;

import com.codej.dto.PatientDTO;
import com.codej.model.Patient;
import com.codej.service.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/hateoas/{id}")
    public EntityModel<PatientDTO> getPatientByIdHateoas(@PathVariable UUID id) throws Exception {
        Patient patient = patientService.findById(id);
        EntityModel<PatientDTO> resource = EntityModel.of(modelMapper.map(patient, PatientDTO.class));

        resource.add(linkTo(methodOn(PatientController.class).getPatientById(id)).withSelfRel());
        resource.add(linkTo(methodOn(PatientController.class).getPatients()).withRel("list-pacientes"));
       // resource.add(linkTo(methodOn(PatientController.class).getCitasByPaciente(id)).withRel("citas-paciente"));
        return resource;
    }

    @PostMapping
    public ResponseEntity<PatientDTO> savePatient(@Valid @RequestBody PatientDTO dto) throws Exception {

        Patient patient = modelMapper.map(dto, Patient.class);
        Patient savedPatient = patientService.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPatient.getIdPatient()).toUri();

        return ResponseEntity.created(location).body(modelMapper.map(savedPatient, PatientDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@Valid @RequestBody PatientDTO dto, @PathVariable UUID id) throws Exception {
        Patient patient = modelMapper.map(dto, Patient.class);
        Patient upadatePatient = patientService.update(patient, id);
        return ResponseEntity.ok(modelMapper.map(upadatePatient, PatientDTO.class));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePatient(@PathVariable UUID id) throws Exception {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

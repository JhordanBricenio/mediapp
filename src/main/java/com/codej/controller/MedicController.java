package com.codej.controller;

import com.codej.dto.MedicDTO;
import com.codej.model.Medic;
import com.codej.service.IMedicService;
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
@RequestMapping("/medics")
@RequiredArgsConstructor
public class MedicController {

    private final IMedicService medicService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MedicDTO>> getMedics() throws Exception {
        List<MedicDTO> medics = medicService.findAll().stream().map(medic-> modelMapper.map(medic, MedicDTO.class)).toList();
        return ResponseEntity.ok(medics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDTO> getMedicById(@PathVariable UUID id) throws Exception {
        Medic medic = medicService.findById(id);
        return ResponseEntity.ok(modelMapper.map(medic, MedicDTO.class));
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<MedicDTO> getMedicByIdHateoas(@PathVariable UUID id) throws Exception {
        Medic medic = medicService.findById(id);
        EntityModel<MedicDTO> resource = EntityModel.of(modelMapper.map(medic, MedicDTO.class));

        resource.add(linkTo(methodOn(MedicController.class).getMedicById(id)).withSelfRel());
        resource.add(linkTo(methodOn(MedicController.class).getMedics()).withRel("list-pacientes"));
        return resource;
    }

    @PostMapping
    public ResponseEntity<MedicDTO> savemedic(@Valid @RequestBody MedicDTO dto) throws Exception {

        Medic medic = modelMapper.map(dto, Medic.class);
        Medic savedmedic = medicService.save(medic);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedmedic.getIdMedic()).toUri();

        return ResponseEntity.created(location).body(modelMapper.map(savedmedic, MedicDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDTO> updateMedic(@Valid @RequestBody MedicDTO dto, @PathVariable UUID id) throws Exception {
        Medic medic = modelMapper.map(dto, Medic.class);
        Medic upadatemedic = medicService.update(medic, id);
        return ResponseEntity.ok(modelMapper.map(upadatemedic, MedicDTO.class));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteMedic(@PathVariable UUID id) throws Exception {
        medicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

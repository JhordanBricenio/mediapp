package com.codej.service.impl;

import com.codej.model.Patient;
import com.codej.repository.IGenericRepository;
import com.codej.repository.IPatientRepository;
import com.codej.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public  class PatientServiceImp extends CRUDGenericImp<Patient, UUID> implements IPatientService {

    private final IPatientRepository patientRepository;


    @Override
    protected IGenericRepository<Patient, UUID> getRepository() {
        return patientRepository;
    }
}

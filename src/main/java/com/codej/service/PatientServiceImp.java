package com.codej.service;

import com.codej.model.Patient;
import com.codej.repository.PatientRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements IPatientService {

    private final PatientRepositoryImpl patientRepositoryImpl;

    @Override
    public Patient validAndSave(Patient patient) {
        return null;
    }
}

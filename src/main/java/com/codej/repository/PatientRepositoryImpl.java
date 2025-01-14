package com.codej.repository;

import com.codej.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryImpl implements IPatientRepository {

    public Patient save(Patient patient) {
        System.out.println("Saving patient");
        return patient;
    }
}

package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

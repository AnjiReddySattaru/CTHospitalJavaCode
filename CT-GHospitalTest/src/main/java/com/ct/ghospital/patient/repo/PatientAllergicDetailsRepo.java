package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.PatientAllergyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientAllergicDetailsRepo extends JpaRepository<PatientAllergyDetails, Integer> {
    List<PatientAllergyDetails> findByPatientPatientId(Integer patientId);
}

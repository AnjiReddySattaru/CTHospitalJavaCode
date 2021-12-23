package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Integer> {
    PatientDetails findByPatientPatientId(Integer patientid);
}

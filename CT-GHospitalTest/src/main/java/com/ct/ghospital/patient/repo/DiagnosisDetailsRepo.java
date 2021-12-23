package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.DiagnosisDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisDetailsRepo extends JpaRepository<DiagnosisDetails, Integer> {
}

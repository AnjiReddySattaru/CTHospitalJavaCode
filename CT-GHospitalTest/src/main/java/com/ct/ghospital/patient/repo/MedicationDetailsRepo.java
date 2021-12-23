package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.MedicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDetailsRepo extends JpaRepository<MedicationDetails, Integer> {
}

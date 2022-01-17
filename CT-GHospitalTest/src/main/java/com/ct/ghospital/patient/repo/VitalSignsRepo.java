package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.util.Status;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalSignsRepo extends JpaRepository<VitalSigns, Integer> {
	VitalSigns findByPatientIdAndStatus(long patientId, Status status);
}

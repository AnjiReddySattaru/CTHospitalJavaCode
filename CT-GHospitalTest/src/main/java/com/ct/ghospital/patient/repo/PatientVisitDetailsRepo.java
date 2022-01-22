package com.ct.ghospital.patient.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.ghospital.patient.model.PatientVisitDetails;

public interface PatientVisitDetailsRepo extends JpaRepository<PatientVisitDetails, Integer> {
	 Optional<PatientVisitDetails> findByPatientIdAndAppointmentId(long id,long aid);
	
}

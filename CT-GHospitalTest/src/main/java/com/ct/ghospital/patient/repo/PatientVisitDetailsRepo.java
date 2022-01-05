package com.ct.ghospital.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.ghospital.patient.model.PatientVisitDetails;

public interface PatientVisitDetailsRepo extends JpaRepository<PatientVisitDetails, Integer> {

}

package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.MedicationDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDetailsRepo extends JpaRepository<MedicationDetails, Integer> {
	List<MedicationDetails> findByMedicationForm(String medicationForm);
	List<MedicationDetails> findByMedicationGenericName(String medicationGenericName);
}

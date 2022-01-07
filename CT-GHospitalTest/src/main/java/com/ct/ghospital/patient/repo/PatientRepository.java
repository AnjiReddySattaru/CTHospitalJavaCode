package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	public Patient findByEmailId(String email);
	public boolean existsByEmailId(String email);
	public List<Patient> findAll();
	
	@Transactional
	@Query("Select p from  patient p ORDER BY id ")
	public List<Patient> getAllPatientList();

}

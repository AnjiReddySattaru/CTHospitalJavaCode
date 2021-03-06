package com.ct.ghospital.patient.repo;


import com.ct.ghospital.patient.model.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	public Patient findByEmailId(String email);
	public boolean existsByEmailId(String email);
	public List<Patient> findAll();
	
	//public Patient findById(long id);
	
	@Transactional
	@Query("Select p from  patient p ORDER BY id ")
	public List<Patient> getAllPatientList();
	
	@Transactional
 	@Query("from patient where status =:statuscheck ")
	List<Patient> patientByStatusList(@Param("statuscheck") char statuscheck);
	
	@Query("Select p from  patient p where p.status = 'A' ")
	public List<Patient> getAllActivePatientList();


	
	@Transactional
	@Query("Select status,count(id) from patient group by status ORDER BY status" )
	List<Object[]> countPatient();
}

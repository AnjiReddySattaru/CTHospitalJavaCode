package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.ProceduresDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureDetailsRepo extends JpaRepository<ProceduresDetails, Integer> {
	
	ProceduresDetails findByProceduresCode(String procedurecode);
}

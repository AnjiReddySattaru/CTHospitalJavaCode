package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.DiagnosisDetailsException;
import com.ct.ghospital.patient.exception.ProcedureDetailsException;
import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.model.ProceduresDetails;
import com.ct.ghospital.patient.repo.ProcedureDetailsRepo;
import com.ct.ghospital.patient.service.ProcedureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcedureDetailsServiceImpl implements ProcedureDetailsService {

	@Autowired
	private ProcedureDetailsRepo procedureDetailsRepo;

	@Override
	public List<ProceduresDetails> getAllProcedureDetails() {
		return new ArrayList<>(procedureDetailsRepo.findAll());
	}

	@Override
	public ProceduresDetails getProcedureDetails(Integer id) {
		Optional<ProceduresDetails> proceduresDetailsOptional = procedureDetailsRepo.findById(id);
		if (proceduresDetailsOptional.isPresent()) {
			return proceduresDetailsOptional.get();
		} else {
			throw new ProcedureDetailsException("Procedure with " + id + " is not present");
		}
	}

	@Override
	public ProceduresDetails saveProcedureDetails(ProceduresDetails proceduresDetails) {
		return procedureDetailsRepo.save(proceduresDetails);
	}

	@Override
	public ProceduresDetails updateProcedureDetails(Integer id, ProceduresDetails proceduresDetails) {
		ProceduresDetails pProceduresDetails = getProcedureDetails(id);
		pProceduresDetails.setProceduresCode(proceduresDetails.getProceduresCode());
		pProceduresDetails.setProceduresName(proceduresDetails.getProceduresName());
		pProceduresDetails.setProcedureIsDepricated(proceduresDetails.getProcedureIsDepricated());
		return procedureDetailsRepo.save(pProceduresDetails);
	}

	@Override
	public void deleteProcedureDetails(Integer id) {
		ProceduresDetails proceduresDetails = getProcedureDetails(id);
		procedureDetailsRepo.delete(proceduresDetails);
	}

	@Override
	public ProceduresDetails getProcedurebycode(String procedurecode) {
		Optional<ProceduresDetails> procedurecodeOptional = Optional.ofNullable(procedureDetailsRepo.findByProceduresCode(procedurecode));
		if (procedurecodeOptional.isPresent()) {
			return procedurecodeOptional.get();
		} else {
			throw new DiagnosisDetailsException("Diagnosis Code is not present");
		}
		
	}
}
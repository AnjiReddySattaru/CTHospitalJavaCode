package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.ProcedureDetailsException;
import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.model.ProceduresDetails;
import com.ct.ghospital.patient.service.ProcedureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProcedureDetailsController {

	@Autowired
	private final ProcedureDetailsService procedureDetailsService;

	public ProcedureDetailsController(ProcedureDetailsService procedureDetailsService) {
		this.procedureDetailsService = procedureDetailsService;
	}

	@GetMapping("/procedure")
	public List<ProceduresDetails> getAllProceduresDetails() {
		return procedureDetailsService.getAllProcedureDetails();
	}
	
	@GetMapping("/procedurebycode/{procedurecode}")
	public ProceduresDetails getDiagnosiscodebydesc(@PathVariable("procedurecode") String procedurecode) {
		return procedureDetailsService.getProcedurebycode(procedurecode);
	}

	@GetMapping("/procedure/{procedureid}")
	public ResponseEntity<ProceduresDetails> getProcedureDetails(@PathVariable("procedureid") Integer procedureid) {
		try {
			return ResponseEntity.ok(procedureDetailsService.getProcedureDetails(procedureid));
		} catch (ProcedureDetailsException ex) {
			throw new ProcedureDetailsException(ex.getMessage());
		}
	}

	@PostMapping("procedure")
	public ProceduresDetails saveProcedureDetails(@RequestBody ProceduresDetails proceduresDetails) {
		return procedureDetailsService.saveProcedureDetails(proceduresDetails);
	}

	@PutMapping("/procedure/{procedureid}")
	public ProceduresDetails updateProcedureDetails(@PathVariable("procedureid") Integer procedureid,
			@RequestBody ProceduresDetails proceduresDetails) {
		return procedureDetailsService.updateProcedureDetails(procedureid, proceduresDetails);
	}

	@DeleteMapping("/procedure/{procedureid}")
	public void deleteProcedureDetails(@PathVariable("procedureid") Integer procedureid) {
		procedureDetailsService.deleteProcedureDetails(procedureid);
	}
}
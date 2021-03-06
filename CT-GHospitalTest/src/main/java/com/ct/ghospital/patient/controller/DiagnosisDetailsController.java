package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.DiagnosisDetailsException;
import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.service.DiagnosisDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DiagnosisDetailsController {

	@Autowired
	private final DiagnosisDetailsService diagnosisDetailsService;

	public DiagnosisDetailsController(DiagnosisDetailsService diagnosisDetailsService) {
		this.diagnosisDetailsService = diagnosisDetailsService;
	}

	@GetMapping("/diagnosis")
	public List<DiagnosisDetails> getAllDiagnosisDetails() {
		return diagnosisDetailsService.getAllDiagnosisDetails();
	}
	
	@GetMapping("/diagnosisbycode/{diagnosiscode}")
	public DiagnosisDetails getDiagnosiscodebydesc(@PathVariable("diagnosiscode") String diagnosiscode) {
		return diagnosisDetailsService.getDiagnosisbycode(diagnosiscode);
	}
	 
 
	
	

	@GetMapping("/diagnosis/{diagnosisid}")
	public ResponseEntity<DiagnosisDetails> getDiagnosisDetails(@PathVariable("diagnosisid") Integer diagnosisid) {
		try {
			return ResponseEntity.ok(diagnosisDetailsService.getDiagnosisDetails(diagnosisid));
		} catch (DiagnosisDetailsException ex) {
			throw new DiagnosisDetailsException(ex.getMessage());
		}
	}

	@PostMapping("diagnosis")
	public DiagnosisDetails saveDiagnosis(@RequestBody DiagnosisDetails diagnosisDetails) {
		return diagnosisDetailsService.saveDiagnosisDetails(diagnosisDetails);
	}

	@PutMapping("/diagnosis/{diagnosisid}")
	public DiagnosisDetails updateDiagnosisDetails(@PathVariable("diagnosisid") Integer diagnosisid,
			@RequestBody DiagnosisDetails diagnosisDetails) {
		return diagnosisDetailsService.updateDiagnosisDetails(diagnosisid, diagnosisDetails);
	}

	@DeleteMapping("/diagnosis/{diagnosisid}")
	public void deleteDiagnosis(@PathVariable("diagnosisid") Integer diagnosisid) {
		diagnosisDetailsService.deleteDiagnosisDetails(diagnosisid);
	}
}

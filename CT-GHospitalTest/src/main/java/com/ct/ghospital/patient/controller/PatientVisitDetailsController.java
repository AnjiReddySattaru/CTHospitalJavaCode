package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.PatientVisitDetailsException;
import com.ct.ghospital.patient.model.PatientVisitDetails;
import com.ct.ghospital.patient.service.PatientVisitDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PatientVisitDetailsController {

	@Autowired
	private final PatientVisitDetailsService patientVisitDetailsService;

	public PatientVisitDetailsController(PatientVisitDetailsService patientVisitDetailsService) {
		this.patientVisitDetailsService = patientVisitDetailsService;
	}

	@GetMapping("/patientvisit/findall/{patientId}")
	public List<PatientVisitDetails> getAllVisitDetails(@PathVariable("patientId") long patientId) {
		return patientVisitDetailsService.getAllVisitDetails(patientId);
	}
	
	@GetMapping("patientvisit/visitbyappointment/{patientId}/{appointmentId}")
	public PatientVisitDetails getvisitbyappointment(@PathVariable("patientId") long patientId,@PathVariable("appointmentId") long appointmentId){
		return patientVisitDetailsService.getvisitappointment(patientId,appointmentId);
	}
	
	
	@GetMapping("/patientvisit/getall")
	public List<PatientVisitDetails> getAllPatientVisit(){
		return patientVisitDetailsService.getAllPatientVisit();
	}

	@GetMapping("/patientvisit/{patientVisitId}")
	public ResponseEntity<PatientVisitDetails> getVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId)
			throws PatientVisitDetailsException {
		try {
			return ResponseEntity.ok(patientVisitDetailsService.getVisitDetails(patientVisitId));
		} catch (PatientVisitDetailsException e) {
			throw new PatientVisitDetailsException(e.getMessage());
		}
	}

	@PostMapping("/patientvisit")
	public PatientVisitDetails savePatientVisitDetails(@RequestBody PatientVisitDetails patientVisitDetails) {
		return patientVisitDetailsService.savePatientVisitDetails(patientVisitDetails);
	}

	@PutMapping("/patientvisit/{patientVisitId}")
	public PatientVisitDetails updatePatientVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId,
			@RequestBody PatientVisitDetails patientVisitDetails) throws PatientVisitDetailsException {
		return patientVisitDetailsService.updateVisitDetails(patientVisitId, patientVisitDetails);
	}

	@DeleteMapping("/patientvisit/{patientVisitId}")
	public void deletePatientVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId)
			throws PatientVisitDetailsException {
		patientVisitDetailsService.deleteVisitDetails(patientVisitId);
	}
}

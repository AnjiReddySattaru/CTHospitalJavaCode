package com.ct.ghospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.ghospital.patient.exception.PatientVisitDetailsException;
import com.ct.ghospital.patient.model.PatientVisitDetails;
import com.ct.ghospital.patient.service.PatientVisitDetailsService;

@RestController
public class PatientVisitDetailsController {

	@Autowired
	private PatientVisitDetailsService patientVisitDetailsService;



	@GetMapping("/patientvisit/findall/{patientId}")
	public List<PatientVisitDetails> getAllVisitDetails(@PathVariable("patientId") Integer patientId) {
	return patientVisitDetailsService.getAllVisitDetails(patientId);
	}



	@GetMapping("/patientvisit/{patientVisitId}")
	public ResponseEntity<PatientVisitDetails> getVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId) throws PatientVisitDetailsException {
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
	public PatientVisitDetails updatePatientVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId, @RequestBody PatientVisitDetails patientVisitDetails) throws PatientVisitDetailsException {
	return patientVisitDetailsService.updateVisitDetails(patientVisitId, patientVisitDetails);
	}



	@DeleteMapping("/patientvisit/{patientVisitId}")
	public void deletePatientVisitDetails(@PathVariable("patientVisitId") Integer patientVisitId) throws PatientVisitDetailsException {
	patientVisitDetailsService.deleteVisitDetails(patientVisitId);
	}
}

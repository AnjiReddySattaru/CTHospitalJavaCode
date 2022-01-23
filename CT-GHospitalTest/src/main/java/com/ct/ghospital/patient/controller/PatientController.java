package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.dto.PatientDashboardDTO;
import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.service.PatientService;
import com.ct.ghospital.patient.service.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class PatientController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/patient")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}

	@GetMapping("/patient/{patientid}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("patientid") Integer patientid) {
		try {
			return ResponseEntity.ok(patientService.getPatientById(patientid));
		} catch (PatientExceptions ex) {
			throw new PatientExceptions(ex.getMessage());
		}
	}

	@PostMapping("/patient")
	public ResponseEntity<String> createPatient(@RequestBody @Valid Patient patientregistartion) {

		ServiceResponse response = patientService.createPatient(patientregistartion);
		switch (response) {
		case EmailExist:
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email id already Exist");
		case passwordNotMatched:
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body("Passwords do not match. Please re-enter the password");
		case RegistrationSuccess:
			return ResponseEntity.status(HttpStatus.CREATED).body("Patient Registartion Successfully");
		default:
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured while saving data");

		}
	}

	@PutMapping("/patient/{patientid}")
	public Patient updatePatient(@PathVariable("patientid") Integer patientid, @RequestBody Patient patients) {
		return patientService.update(patientid, patients);
	}

	@DeleteMapping("/patient/{patientid}")
	public void deletePatient(@PathVariable("patientid") Integer patientid) {
		patientService.deletePatient(patientid);
	}

	@GetMapping("/getPatientByStatus/{statusid}")
	public ResponseEntity<List<PatientDashboardDTO>> getEmployeeByStatus(@PathVariable("statusid") char statusid) {
		System.out.print("this is status id" + statusid);
		return new ResponseEntity<>(patientService.employeeListbyStatus(statusid), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/updatepatientStatus")
	public ResponseEntity<Boolean> updateEmployeeStatus(@RequestBody Patient patient) {
		System.out.println("in update employee status controller");
		System.out.println(patient);
		if (patientService.updatePatientStatus((long) patient.getId(), (char) patient.getStatus()))
			return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);

	}

	@PatchMapping("/resetPassword")
	public ResponseEntity<Boolean> resetEmployeePassword(@RequestBody Patient patient) {
		System.out.println("in update employee reset controller");
		System.out.println(patient);
		if (patientService.resetPatientPassword((long)patient.getId()))
			return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/patientCountByStatus")
	public ResponseEntity<List<Object[]> > employeeCountByStatus(){
		
//		employeeservice.countByStatus().forEach(System.out::println);
				return new ResponseEntity<>( patientService.countByStatus(), HttpStatus.OK);
	
	}
}

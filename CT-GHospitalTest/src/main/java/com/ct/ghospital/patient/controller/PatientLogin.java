package com.ct.ghospital.patient.controller;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.ghospital.patient.dto.LoginDto;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.service.PatientService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/login")
public class PatientLogin {
	
	@Autowired
	PatientService serviceimpl;
	
	@PostMapping(path="/checkuser" , produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Patient> checkCredentials(@RequestBody Patient patient) {
		Patient emp = serviceimpl.checkLogin(patient.getEmailId(), patient.getPassword());
//		Employeedto empdto = new Employeedto();
//		empdto.setFirstLogin(emp.getFirstLogin());
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	


	@PostMapping("/token")
	public String getToken(@RequestBody LoginDto loginDto) {
		return serviceimpl.getToken(loginDto.getUsername(), loginDto.getPassword());
	
	}
	
	@PostMapping("/tokenobject")
	public AccessTokenResponse getTokenObject(@RequestBody LoginDto loginDto) {
		return serviceimpl.getTokenObject(loginDto.getUsername(), loginDto.getPassword());
	
	}
}

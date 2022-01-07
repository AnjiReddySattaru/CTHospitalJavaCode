//package com.ct.ghospital.patient.controller;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.ct.ghospital.patient.model.Patient;
//import com.ct.ghospital.patient.service.ServiceResponse;
//import com.ct.ghospital.patient.serviceimpl.PatientServiceImpl;
//
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//
//
//
//
//
//@CrossOrigin(origins="http://localhost:4200")
//@RestController
//
//@Validated
//public class PatientRegistartion {
//
//	
//	@Autowired
//	PatientServiceImpl serviceimpl;
//	
////	@ApiOperation(value = "pull patient data", notes = "method for patient registration")
////	@ApiResponses
////	(
////			{
////				@ApiResponse(code = 201, message = "Patient Registartion Successfully", response = String.class),
////				@ApiResponse(code = 409, message = "Email id already Exist", response = String.class),
////				@ApiResponse(code = 417, message = "Passwords do not match. Please re-enter the password", response = String.class),
////				@ApiResponse(code = 400, message = "Error occured while saving data", response = String.class)
////			}
////	)
//	
//	
//	@GetMapping("/patient")
//	public List<Patient> getAllPatient()
//	{
//		
//		return serviceimpl.getPatient();
//		
//	}
//	
//	@GetMapping("/patient/{id}")
//	public ResponseEntity<Optional<Patient>> getPatientByid(@PathVariable long id)
//	{
//		Optional<Patient> p=serviceimpl.getPatient(id);
//		if(p.isPresent())
//			return ResponseEntity.status(HttpStatus.FOUND).body(p);
//		else
//			 return ResponseEntity.notFound().build();
//		
//		
//	}
//	
//	
//	
//}

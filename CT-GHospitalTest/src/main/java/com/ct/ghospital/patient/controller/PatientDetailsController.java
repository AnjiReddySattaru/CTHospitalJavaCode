package com.ct.ghospital.patient.controller;


import com.ct.ghospital.patient.dto.PatientDetailsDTO;
import com.ct.ghospital.patient.exception.PatientAllergicDetailsException;
import com.ct.ghospital.patient.exception.PatientDetailsExceptions;
import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.service.PatientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientDetailsController {

    @Autowired
    private PatientDetailsService patientDetailsService;

    @GetMapping("/patient-details")
    public List<PatientDetailsDTO> getAllPatientDetails() {
        return patientDetailsService.getAllPatientAndAllergicDetails();
    }

    @GetMapping("/patient-details/{patientId}")
    public PatientDetailsDTO getPatientDetails(@PathVariable Integer patientId) {
        return patientDetailsService.getPatientAndAllergicDetails(patientId);
    }

    @PostMapping("/patient-details")
    public ResponseEntity<PatientDetailsDTO> savePatientAndAllergicDetails(@RequestBody PatientDetailsDTO patientDetailsDTO) {
        try {
            return ResponseEntity.ok(patientDetailsService.savePatientAndAllergicDetails(patientDetailsDTO));
        } catch (PatientDetailsExceptions ex) {
            throw new PatientDetailsExceptions(ex.getMessage());
        } catch (PatientAllergicDetailsException ex) {
            throw new PatientAllergicDetailsException(ex.getMessage());
        }
    }

    @PutMapping("/patient-details/{patientId}")
    public PatientDetailsDTO updatePatientAndAllergicDetails(@PathVariable Integer patientId, @RequestBody PatientDetailsDTO patientDetailsDTO) throws Exception {
        return patientDetailsService.updatePatientAndAllergicDetails(patientId, patientDetailsDTO);
    }

    @DeleteMapping("/patient-details/{patientId}")
    public void deletePatientAndAllergicDetails(@PathVariable Integer patientId) throws Exception {
        try {
            patientDetailsService.deletePatientAndAllergicDetails(patientId);
        } catch (PatientExceptions ex) {
            throw new PatientExceptions(ex.getMessage());
        }
    }
}

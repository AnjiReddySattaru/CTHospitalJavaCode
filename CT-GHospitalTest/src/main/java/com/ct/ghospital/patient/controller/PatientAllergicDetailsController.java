package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.PatientAllergicDetailsException;
import com.ct.ghospital.patient.model.PatientAllergyDetails;
import com.ct.ghospital.patient.service.PatientAllergicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientAllergicDetailsController {
    @Autowired
    private PatientAllergicDetailsService patientAllergicDetailsService;

    @GetMapping("/patientallergic")
    public List<PatientAllergyDetails> getAllPatientAllergicDetails() {
        return patientAllergicDetailsService.getAllPatientAllergicDetails();
    }

    @GetMapping("/patientallergic/{patientallergicid}")
    public ResponseEntity<PatientAllergyDetails> getPatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid) {
        try {
            return ResponseEntity.ok(patientAllergicDetailsService.getPatientAllergicDetails(patientallergicid));
        } catch (PatientAllergicDetailsException ex) {
            throw new PatientAllergicDetailsException(ex.getMessage());
        }
    }

    @PostMapping("/patientallergic")
    public PatientAllergyDetails savePatientAllergicDetails(@RequestBody PatientAllergyDetails patientAllergyDetails) {
        return patientAllergicDetailsService.savePatientAllergicDetails(patientAllergyDetails);
    }

    @PutMapping("/patientallergic/{patientallergicid}")
    public PatientAllergyDetails updatePatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid, PatientAllergyDetails patientAllergyDetails) {
        return patientAllergicDetailsService.updatePatientAllergicDetails(patientallergicid, patientAllergyDetails);
    }

    @DeleteMapping("/patientallergic/{patientallergicid}")
    public void deletePatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid) {
        patientAllergicDetailsService.deletePatientAllergicDetails(patientallergicid);
    }
}

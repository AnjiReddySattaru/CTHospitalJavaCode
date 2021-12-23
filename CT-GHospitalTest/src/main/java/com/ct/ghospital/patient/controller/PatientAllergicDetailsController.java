package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.PatientAllergyDetails;
import com.ct.ghospital.patient.serviceimpl.PatientAllergicDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientAllergicDetailsController {
    @Autowired
    private PatientAllergicDetailsServiceImpl patientAllergicDetailsServiceImpl;

    @GetMapping("/patientallergic")
    private List<PatientAllergyDetails> getAllPatientAllergicDetails() {
        return patientAllergicDetailsServiceImpl.getAllPatientAllergicDetails();
    }

    @GetMapping("/patientallergic/{patientallergicid}")
    private PatientAllergyDetails getPatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid) throws Exception {
        return patientAllergicDetailsServiceImpl.getPatientAllergicDetails(patientallergicid);
    }

    @PostMapping("/patientallergic")
    private PatientAllergyDetails savePatientAllergicDetails(@RequestBody PatientAllergyDetails patientAllergyDetails) {
        return patientAllergicDetailsServiceImpl.savePatientAllergicDetails(patientAllergyDetails);
    }

    @PutMapping("/patientallergic/{patientallergicid}")
    private PatientAllergyDetails updatePatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid, PatientAllergyDetails patientAllergyDetails) throws Exception {
        return patientAllergicDetailsServiceImpl.updatePatientAllergicDetails(patientallergicid, patientAllergyDetails);
    }

    @DeleteMapping("/patientallergic/{patientallergicid}")
    private void deletePatientAllergicDetails(@PathVariable("patientallergicid") Integer patientallergicid) throws Exception {
        patientAllergicDetailsServiceImpl.deletePatientAllergicDetails(patientallergicid);
    }
}

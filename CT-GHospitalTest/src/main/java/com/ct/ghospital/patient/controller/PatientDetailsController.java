package com.ct.ghospital.patient.controller;


import com.ct.ghospital.patient.dto.PatientDetailsDTO;
import com.ct.ghospital.patient.service.PatientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientDetailsController {

    @Autowired
    private PatientDetailsService patientDetailsService;

    @GetMapping("/patieent-details")
    public List<PatientDetailsDTO> getAllPatientDetails() {
        return patientDetailsService.getAllPatientAndAllergicDetails();
    }

    @GetMapping("/patieent-details/{patieent_details_id}")
    public PatientDetailsDTO getPatientDetails(@PathVariable Integer patieent_details_id) {
        return patientDetailsService.getPatientAndAllergicDetails(patieent_details_id);
    }

    @PostMapping("/patient-details/allergic-details")
    public PatientDetailsDTO savePatientAndAllergicDetails(@RequestBody PatientDetailsDTO patientDetailsDTO) throws Exception {
        return patientDetailsService.savePatientAndAllergicDetails(patientDetailsDTO);
    }

    @PutMapping("/patieent-details/{patieent_details_id}")
    public PatientDetailsDTO updatePatientAndAllergicDetails(@PathVariable Integer patieent_details_id, @RequestBody PatientDetailsDTO patientDetailsDTO) throws Exception {
        return patientDetailsService.updatePatientAndAllergicDetails(patieent_details_id, patientDetailsDTO);
    }

    @DeleteMapping("/patieent-details/{patieent_details_id}")
    public void deletePatientAndAllergicDetails(@PathVariable Integer patieent_details_id) throws Exception {
        patientDetailsService.deletePatientAndAllergicDetails(patieent_details_id);
    }
}

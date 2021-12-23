package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.MedicationDetails;
import com.ct.ghospital.patient.serviceimpl.MedicationDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicationDetailsController {

    @Autowired
    private MedicationDetailsServiceImpl medicationDetailsServiceImpl;

    @GetMapping("/medication")
    private List<MedicationDetails> getAllMedicationDetails() {
        return medicationDetailsServiceImpl.getAllMedicationDetails();
    }

    @GetMapping("/medication/{medicationid}")
    private MedicationDetails getMedicationDetails(@PathVariable("medicationid") Integer medicationid) throws Exception {
        return medicationDetailsServiceImpl.getMedicationDetails(medicationid);
    }

    @PostMapping("/medication")
    private MedicationDetails saveMedicationDetails(@RequestBody MedicationDetails medicationDetails) {
        return medicationDetailsServiceImpl.saveMedicationDetails(medicationDetails);
    }

    @PutMapping("/medication/medicationid")
    private MedicationDetails updateMedicationDetails(@PathVariable("medicationid") Integer medicationid, MedicationDetails medicationDetails) throws Exception {
        return medicationDetailsServiceImpl.updateMedicationDetails(medicationid, medicationDetails);
    }

    @DeleteMapping("/medication/medicationid")
    private void deleteMedication(@PathVariable("medicationid") Integer medicationid) throws Exception {
        medicationDetailsServiceImpl.deleteMedication(medicationid);
    }
}

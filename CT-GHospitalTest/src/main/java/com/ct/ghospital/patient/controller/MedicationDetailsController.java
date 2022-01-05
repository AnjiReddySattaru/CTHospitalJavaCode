package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.MedicationDetailsException;
import com.ct.ghospital.patient.model.MedicationDetails;
import com.ct.ghospital.patient.service.MedicationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost:4200")
public class MedicationDetailsController {

    @Autowired
    private MedicationDetailsService medicationDetailsService;

    @GetMapping("/medication")
    public List<MedicationDetails> getAllMedicationDetails() {
        return medicationDetailsService.getAllMedicationDetails();
    }

    @GetMapping("/medication/{medicationid}")
    public ResponseEntity<MedicationDetails> getMedicationDetails(@PathVariable("medicationid") Integer medicationid) {
        try {
            return ResponseEntity.ok(medicationDetailsService.getMedicationDetails(medicationid));
        } catch (MedicationDetailsException ex) {
            throw new MedicationDetailsException(ex.getMessage());
        }
    }

    @PostMapping("/medication")
    public MedicationDetails saveMedicationDetails(@RequestBody MedicationDetails medicationDetails) {
        return medicationDetailsService.saveMedicationDetails(medicationDetails);
    }

    @PutMapping("/medication/medicationid")
    public MedicationDetails updateMedicationDetails(@PathVariable("medicationid") Integer medicationid, MedicationDetails medicationDetails) {
        return medicationDetailsService.updateMedicationDetails(medicationid, medicationDetails);
    }

    @DeleteMapping("/medication/medicationid")
    public void deleteMedication(@PathVariable("medicationid") Integer medicationid) {
        medicationDetailsService.deleteMedication(medicationid);
    }
}

package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.VitalSignsException;
import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.service.VitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VitalSignsController {

    @Autowired
    private VitalSignsService vitalSignsService;

    @GetMapping("/vitalsigns")
    public List<VitalSigns> getAllVitalSigns() {
        return vitalSignsService.getAllVitalSignsDetails();
    }

    @GetMapping("/vitalsigns/{patientId}")
    public ResponseEntity<VitalSigns> getVitalSigns(@PathVariable("patientId") long patientId) {
        try {
            return ResponseEntity.ok(vitalSignsService.getVitalSignsDetails(patientId));
        } catch (VitalSignsException ex) {
            throw new VitalSignsException(ex.getMessage());
        }
    }

    @PostMapping("/vitalsigns")
    public VitalSigns saveVitalSigns(@RequestBody VitalSigns vitalsigns) {
        return vitalSignsService.saveVitalSignsDetails(vitalsigns);
    }

    @PutMapping("/vitalsigns/{patientId}")
    public VitalSigns updateVitalSigns(@PathVariable("patientId") long patientId, @RequestBody VitalSigns vitalSigns) {
        return vitalSignsService.updateVitalSignsDetails(patientId, vitalSigns);
    }

    @DeleteMapping("/vitalsigns/{vitalsignsid}")
    public void deleteVitalSigns(@PathVariable("vitalsignsid") long vitalsignsid) {
        vitalSignsService.deleteVitalSigns(vitalsignsid);
    }
}

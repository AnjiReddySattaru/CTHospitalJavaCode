package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.VitalSignsException;
import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.service.VitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost:4200")
public class VitalSignsController {

    @Autowired
    private VitalSignsService vitalSignsService;

    @GetMapping("/vitalsigns")
    public List<VitalSigns> getAllVitalSigns() {
        return vitalSignsService.getAllVitalSignsDetails();
    }

    @GetMapping("/vitalsigns/{vitalsignsid}")
    public ResponseEntity<VitalSigns> getVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid) {
        try {
            return ResponseEntity.ok(vitalSignsService.getVitalSignsDetails(vitalsignsid));
        } catch (VitalSignsException ex) {
            throw new VitalSignsException(ex.getMessage());
        }
    }

    @PostMapping("/vitalsigns")
    public VitalSigns saveVitalSigns(@RequestBody VitalSigns vitalsigns) {
        return vitalSignsService.saveVitalSignsDetails(vitalsigns);
    }

    @PutMapping("/vitalsigns/{vitalsignsid}")
    public VitalSigns updateVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid, @RequestBody VitalSigns vitalSigns) {
        return vitalSignsService.updateVitalSignsDetails(vitalsignsid, vitalSigns);
    }

    @DeleteMapping("/vitalsigns/{vitalsignsid}")
    public void deleteVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid) {
        vitalSignsService.deleteVitalSigns(vitalsignsid);
    }
}

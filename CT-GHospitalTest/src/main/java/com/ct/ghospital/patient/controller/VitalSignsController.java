package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.serviceimpl.VitalSignsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VitalSignsController {

    @Autowired
    private VitalSignsServiceImpl vitalSignsServiceImpl;

    @GetMapping("/vitalsigns")
    private List<VitalSigns> getAllVitalSigns() {
        return vitalSignsServiceImpl.getAllVitalSignsDetails();
    }

    @GetMapping("/vitalsigns/{vitalsignsid}")
    private VitalSigns getVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid) throws Exception {
        return vitalSignsServiceImpl.getVitalSignsDetails(vitalsignsid);
    }

    @PostMapping("/vitalsigns")
    private VitalSigns saveVitalSigns(@RequestBody VitalSigns vitalsigns) {
        return vitalSignsServiceImpl.saveVitalSignsDetails(vitalsigns);
    }

    @PutMapping("/vitalsigns/{vitalsignsid}")
    private VitalSigns updateVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid, @RequestBody VitalSigns vitalSigns) throws Exception {
        return vitalSignsServiceImpl.updateVitalSignsDetails(vitalsignsid, vitalSigns);
    }

    @DeleteMapping("/vitalsigns/{vitalsignsid}")
    private void deleteVitalSigns(@PathVariable("vitalsignsid") Integer vitalsignsid) throws Exception {
        vitalSignsServiceImpl.deleteVitalSigns(vitalsignsid);
    }
}

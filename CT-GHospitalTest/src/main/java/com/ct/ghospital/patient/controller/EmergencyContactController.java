package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.EmergencyContact;
import com.ct.ghospital.patient.serviceimpl.EmergencyContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergencyContactController {
    @Autowired
    private EmergencyContactServiceImpl emergencyContactServiceImpl;

    @GetMapping("/emergency")
    public List<EmergencyContact> getAllEmergencyContactDetails() {
        return emergencyContactServiceImpl.getAllEmergencyContactDetails();
    }

    @GetMapping("/emergency/{emergencyid}")
    public EmergencyContact getEmergencyContactDetails(@PathVariable("emergencyid") Integer emergencyid) throws Exception {
        return emergencyContactServiceImpl.getEmergencyContactDetails(emergencyid);
    }

    @PostMapping("/emergency")
    public EmergencyContact saveEmergencyContact(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactServiceImpl.saveEmergencyContact(emergencyContact);
    }

    @PutMapping("/emergency/{emergencyid}")
    public EmergencyContact updateEmergencyContact(@PathVariable("emergencyid") Integer emergencyid, EmergencyContact emergencyContact) throws Exception {
        return emergencyContactServiceImpl.updateEmergencyContact(emergencyid, emergencyContact);
    }

    @DeleteMapping("/emergency/{emergencyid}")
    public void DeleteEmergencyContact(@PathVariable("emergencyid") Integer emergencyid, EmergencyContact emergencyContact) throws Exception {
        emergencyContactServiceImpl.deleteEmergencyContact(emergencyid);
    }
}

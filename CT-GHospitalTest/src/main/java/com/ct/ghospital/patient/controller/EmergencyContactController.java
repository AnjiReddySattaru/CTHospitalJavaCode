package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.EmergencyContactException;
import com.ct.ghospital.patient.model.EmergencyContact;
import com.ct.ghospital.patient.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost:4200")
public class EmergencyContactController {
    @Autowired
    private EmergencyContactService emergencyContactService;

    @GetMapping("/emergency")
    public List<EmergencyContact> getAllEmergencyContactDetails() {
        return emergencyContactService.getAllEmergencyContactDetails();
    }

    @GetMapping("/emergency/{emergencyid}")
    public ResponseEntity<EmergencyContact> getEmergencyContactDetails(@PathVariable("emergencyid") Integer emergencyid) {
        try {
            return ResponseEntity.ok(emergencyContactService.getEmergencyContactDetails(emergencyid));
        } catch (EmergencyContactException ex) {
            throw new EmergencyContactException(ex.getMessage());
        }
    }

    @PostMapping("/emergency")
    public EmergencyContact saveEmergencyContact(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.saveEmergencyContact(emergencyContact);
    }

    @PutMapping("/emergency/{emergencyid}")
    public EmergencyContact updateEmergencyContact(@PathVariable("emergencyid") Integer emergencyid, EmergencyContact emergencyContact) {
        return emergencyContactService.updateEmergencyContact(emergencyid, emergencyContact);
    }

    @DeleteMapping("/emergency/{emergencyid}")
    public void DeleteEmergencyContact(@PathVariable("emergencyid") Integer emergencyid, EmergencyContact emergencyContact) {
        emergencyContactService.deleteEmergencyContact(emergencyid);
    }
}

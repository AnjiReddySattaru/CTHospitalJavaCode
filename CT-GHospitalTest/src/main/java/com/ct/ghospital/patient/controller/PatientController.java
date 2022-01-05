package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/{patientid}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientid") Integer patientid) {
        try {
            return ResponseEntity.ok(patientService.getPatientById(patientid));
        } catch (PatientExceptions ex) {
            throw new PatientExceptions(ex.getMessage());
        }
    }

    @PostMapping("/patient")
    public Patient savePatient(@RequestBody Patient patients) {
        return patientService.saveOrUpdate(patients);
    }

    @PutMapping("/patient/{patientid}")
    public Patient updatePatient(@PathVariable("patientid") Integer patientid, @RequestBody Patient patients) {
        return patientService.update(patientid, patients);
    }

    @DeleteMapping("/patient/{patientid}")
    public void deletePatient(@PathVariable("patientid") Integer patientid) {
        patientService.deletePatient(patientid);
    }

}

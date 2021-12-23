package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient")
    private List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/{patientid}")
    private Patient getPatientById(@PathVariable("patientid") Integer patientid) throws Exception {
        return patientService.getPatientById(patientid);
    }

    @PostMapping("/patient")
    private Patient savePatient(@RequestBody Patient patients) {
        Patient patient1 = patientService.saveOrUpdate(patients);
        return patient1;
    }

    @PutMapping("/patient/{patientid}")
    private Patient updatePatient(@PathVariable("patientid") Integer patientid, @RequestBody Patient patients) throws Exception {
        Patient patient1 = patientService.update(patientid, patients);
        return patient1;
    }

    @DeleteMapping("/patient/{patientid}")
    private void deletePatient(@PathVariable("patientid") Integer patientid) throws Exception {
        patientService.delete(patientid);
    }

}

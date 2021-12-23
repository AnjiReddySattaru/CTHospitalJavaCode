package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.serviceimpl.DiagnosisDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiagnosisDetailsController {

    @Autowired
    private DiagnosisDetailsServiceImpl diagnosisDetailsServiceImpl;

    @GetMapping("/diagnosis")
    public List<DiagnosisDetails> getAllDiagnosisDetails() {
        return diagnosisDetailsServiceImpl.getAllDiagnosisDetails();
    }

    @GetMapping("/diagnosis/{diagnosisid}")
    public DiagnosisDetails getDiagnosisDetails(@PathVariable("diagnosisid") Integer diagnosisid) throws Exception {
        return diagnosisDetailsServiceImpl.getDiagnosisDetails(diagnosisid);
    }

    @PostMapping("diagnosis")
    public DiagnosisDetails saveDiagnosis(@RequestBody DiagnosisDetails diagnosisDetails) {
        return diagnosisDetailsServiceImpl.saveDiagnosisDetails(diagnosisDetails);
    }

    @PutMapping("/diagnosis/{diagnosisid}")
    public DiagnosisDetails updateDiagnosisDetails(@PathVariable("diagnosisid") Integer diagnosisid, @RequestBody DiagnosisDetails diagnosisDetails) throws Exception {
        return diagnosisDetailsServiceImpl.updateDiagnosisDetails(diagnosisid, diagnosisDetails);
    }

    @DeleteMapping("/diagnosis/{diagnosisid}")
    public void deleteDiagnosis(@PathVariable("diagnosisid") Integer diagnosisid) throws Exception {
        diagnosisDetailsServiceImpl.deleteDiagnosisDetails(diagnosisid);
    }
}

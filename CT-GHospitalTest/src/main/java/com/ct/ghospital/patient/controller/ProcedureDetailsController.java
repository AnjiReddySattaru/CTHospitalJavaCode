package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.ProceduresDetails;
import com.ct.ghospital.patient.serviceimpl.ProcedureDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcedureDetailsController {

    @Autowired
    private ProcedureDetailsServiceImpl procedureDetailsServiceImpl;

    @GetMapping("/procedure")
    private List<ProceduresDetails> getAllProceduresDetails() {
        return procedureDetailsServiceImpl.getAllProcedureDetails();
    }

    @GetMapping("/procedure/{procedureid}")
    private ProceduresDetails getProcedureDetails(@PathVariable("procedureid") Integer procedureid) throws Exception {
        return procedureDetailsServiceImpl.getProcedureDetails(procedureid);
    }

    @PostMapping("procedure")
    private ProceduresDetails saveProcedureDetails(@RequestBody ProceduresDetails proceduresDetails) {
        return procedureDetailsServiceImpl.saveProcedureDetails(proceduresDetails);
    }

    @PutMapping("/procedure/{procedureid}")
    private ProceduresDetails updateProcedureDetails(@PathVariable("procedureid") Integer procedureid, @RequestBody ProceduresDetails proceduresDetails) throws Exception {
        return procedureDetailsServiceImpl.updateProcedureDetails(procedureid, proceduresDetails);
    }

    @DeleteMapping("/procedure/{procedureid}")
    private void deleteProcedureDetails(@PathVariable("procedureid") Integer procedureid) throws Exception {
        procedureDetailsServiceImpl.deleteProcedureDetails(procedureid);
    }
}

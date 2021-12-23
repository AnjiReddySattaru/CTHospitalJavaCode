package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.ProceduresDetails;

import java.util.List;

public interface ProcedureDetailsService {
    List<ProceduresDetails> getAllProcedureDetails();

    ProceduresDetails getProcedureDetails(Integer id) throws Exception;

    ProceduresDetails saveProcedureDetails(ProceduresDetails proceduresDetails);

    ProceduresDetails updateProcedureDetails(Integer id, ProceduresDetails proceduresDetails) throws Exception;

    void deleteProcedureDetails(Integer id) throws Exception;
}

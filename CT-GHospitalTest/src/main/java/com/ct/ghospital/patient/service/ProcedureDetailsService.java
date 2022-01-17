package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.ProcedureDetailsException;
import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.model.ProceduresDetails;



import java.util.List;



public interface ProcedureDetailsService {
List<ProceduresDetails> getAllProcedureDetails();



ProceduresDetails getProcedureDetails(Integer id) throws ProcedureDetailsException;



ProceduresDetails saveProcedureDetails(ProceduresDetails proceduresDetails);



ProceduresDetails updateProcedureDetails(Integer id, ProceduresDetails proceduresDetails) throws ProcedureDetailsException;



void deleteProcedureDetails(Integer id) throws ProcedureDetailsException;

ProceduresDetails getProcedurebycode(String procedurecode);
}

package com.ct.ghospital.patient.service;


import com.ct.ghospital.patient.exception.DiagnosisDetailsException;
import com.ct.ghospital.patient.model.DiagnosisDetails;



import java.util.List;



public interface DiagnosisDetailsService {
List<DiagnosisDetails> getAllDiagnosisDetails();



DiagnosisDetails getDiagnosisDetails(Integer id) throws DiagnosisDetailsException;



DiagnosisDetails saveDiagnosisDetails(DiagnosisDetails diagnosisDetails);



DiagnosisDetails updateDiagnosisDetails(Integer id, DiagnosisDetails diagnosisDetails) throws DiagnosisDetailsException;



void deleteDiagnosisDetails(Integer id) throws DiagnosisDetailsException;

DiagnosisDetails getDiagnosisbycode(String diagnosiscode);

}

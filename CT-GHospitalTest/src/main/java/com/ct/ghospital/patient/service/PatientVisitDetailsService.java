package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.PatientVisitDetailsException;
import com.ct.ghospital.patient.model.PatientVisitDetails;



import java.util.List;



public interface PatientVisitDetailsService {



List<PatientVisitDetails> getAllVisitDetails(long patientId);



PatientVisitDetails getVisitDetails(Integer patientVisitId) throws PatientVisitDetailsException;



PatientVisitDetails savePatientVisitDetails(PatientVisitDetails patientVisitDetails);



PatientVisitDetails updateVisitDetails(Integer patientVisitId, PatientVisitDetails patientVisitDetails) throws PatientVisitDetailsException;



void deleteVisitDetails(Integer patientVisitId) throws PatientVisitDetailsException;
}

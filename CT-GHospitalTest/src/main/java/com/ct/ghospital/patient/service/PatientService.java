package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientById(Integer patientId) throws PatientExceptions;
    Patient saveOrUpdate(Patient patient);
    Patient update(Integer patientid, Patient patients) throws PatientExceptions;
    void deletePatient(Integer patientid) throws PatientExceptions;
}

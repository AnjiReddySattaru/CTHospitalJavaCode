package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.PatientAllergicDetailsException;
import com.ct.ghospital.patient.model.PatientAllergyDetails;

import java.util.List;

public interface PatientAllergicDetailsService {
    List<PatientAllergyDetails> getAllPatientAllergicDetails();

    PatientAllergyDetails getPatientAllergicDetails(Integer patientallergicid) throws PatientAllergicDetailsException;

    PatientAllergyDetails savePatientAllergicDetails(PatientAllergyDetails patientAllergyDetails);

    PatientAllergyDetails updatePatientAllergicDetails(Integer patientallergicid, PatientAllergyDetails patientAllergyDetails) throws PatientAllergicDetailsException;

    void deletePatientAllergicDetails(Integer patientallergicid) throws PatientAllergicDetailsException;
}

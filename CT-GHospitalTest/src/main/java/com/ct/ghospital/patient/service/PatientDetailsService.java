package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.dto.PatientDetailsDTO;

import java.util.List;

public interface PatientDetailsService {

    PatientDetailsDTO savePatientAndAllergicDetails(PatientDetailsDTO patientDetailsDTO);

    List<PatientDetailsDTO> getAllPatientAndAllergicDetails();

    PatientDetailsDTO getPatientAndAllergicDetails(long patient_id);

    PatientDetailsDTO updatePatientAndAllergicDetails(long patient_id, PatientDetailsDTO patientDetailsDTO) throws Exception;

    void deletePatientAndAllergicDetails(long patient_id) throws Exception;
}

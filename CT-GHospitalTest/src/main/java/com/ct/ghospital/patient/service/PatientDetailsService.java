package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.dto.PatientDetailsDTO;

import java.util.List;

public interface PatientDetailsService {

    PatientDetailsDTO savePatientAndAllergicDetails(PatientDetailsDTO patientDetailsDTO);

    List<PatientDetailsDTO> getAllPatientAndAllergicDetails();

    PatientDetailsDTO getPatientAndAllergicDetails(Integer patient_id);

    PatientDetailsDTO updatePatientAndAllergicDetails(Integer patient_id, PatientDetailsDTO patientDetailsDTO) throws Exception;

    void deletePatientAndAllergicDetails(Integer patient_id) throws Exception;
}

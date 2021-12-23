package com.ct.ghospital.patient.dto;

import com.ct.ghospital.patient.model.PatientAllergyDetails;
import com.ct.ghospital.patient.model.PatientDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsDTO {
    PatientDetails patientDetails;
    List<PatientAllergyDetails> patientAllergyDetailsList;
}

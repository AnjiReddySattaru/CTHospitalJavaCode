package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.MedicationDetails;

import java.util.List;

public interface MedicationDetailsService {
    List<MedicationDetails> getAllMedicationDetails();

    MedicationDetails getMedicationDetails(Integer medicationId) throws Exception;

    MedicationDetails saveMedicationDetails(MedicationDetails medicationDetails);

    MedicationDetails updateMedicationDetails(Integer medicationId, MedicationDetails medicationDetails) throws Exception;

    void deleteMedication(Integer medicationId) throws Exception;
}

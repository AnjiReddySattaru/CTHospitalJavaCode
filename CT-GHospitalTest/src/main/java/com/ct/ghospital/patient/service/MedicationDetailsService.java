package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.AllergyDetailsException;
import com.ct.ghospital.patient.exception.MedicationDetailsException;
import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.model.MedicationDetails;

import java.util.List;

public interface MedicationDetailsService {
		List<MedicationDetails> getAllMedicationDetails();



		MedicationDetails getMedicationDetails(Integer medicationId) throws MedicationDetailsException;



		MedicationDetails saveMedicationDetails(MedicationDetails medicationDetails);



		MedicationDetails updateMedicationDetails(Integer medicationId, MedicationDetails medicationDetails) throws MedicationDetailsException;



		void deleteMedication(Integer medicationId) throws MedicationDetailsException;
		
	    List<MedicationDetails> getMedicationbyform(String medicationform) throws MedicationDetailsException;
	    
	    List<MedicationDetails> getMedicationbyname(String medicationname) throws MedicationDetailsException;

		}

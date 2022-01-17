package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.VitalSignsException;
import com.ct.ghospital.patient.model.VitalSigns;



import java.util.List;



public interface VitalSignsService {
List<VitalSigns> getAllVitalSignsDetails();



VitalSigns getVitalSignsDetails(long id) throws VitalSignsException;



VitalSigns saveVitalSignsDetails(VitalSigns vitalSigns);



VitalSigns updateVitalSignsDetails(long id, VitalSigns vitalSigns) throws VitalSignsException;



void deleteVitalSigns(long id) throws VitalSignsException;
}

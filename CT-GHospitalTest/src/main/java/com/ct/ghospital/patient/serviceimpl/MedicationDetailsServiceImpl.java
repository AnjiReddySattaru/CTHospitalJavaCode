package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.MedicationDetailsException;
import com.ct.ghospital.patient.model.MedicationDetails;
import com.ct.ghospital.patient.repo.MedicationDetailsRepo;
import com.ct.ghospital.patient.service.MedicationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class MedicationDetailsServiceImpl implements MedicationDetailsService {



@Autowired
private MedicationDetailsRepo medicationDetailsRepo;



@Override
public List<MedicationDetails> getAllMedicationDetails() {
return new ArrayList<>(medicationDetailsRepo.findAll());
}



@Override
public MedicationDetails getMedicationDetails(Integer medicationId) {
Optional<MedicationDetails> medicationDetailsOptional = medicationDetailsRepo.findById(medicationId);
if (medicationDetailsOptional.isPresent()) {
return medicationDetailsOptional.get();
} else {
throw new MedicationDetailsException("Medication with Id " + medicationId + " is not present");
}
}



@Override
public MedicationDetails saveMedicationDetails(MedicationDetails medicationDetails) {
return medicationDetailsRepo.save(medicationDetails);
}



@Override
public MedicationDetails updateMedicationDetails(Integer medicationId, MedicationDetails medicationDetails) {
MedicationDetails pMedicationDetails = getMedicationDetails(medicationId);
pMedicationDetails.setMedicationName(medicationDetails.getMedicationName());
pMedicationDetails.setMedicationGenericName(medicationDetails.getMedicationGenericName());
pMedicationDetails.setMedicationManufacturerName(medicationDetails.getMedicationManufacturerName());
pMedicationDetails.setMedicationForm(medicationDetails.getMedicationForm());
pMedicationDetails.setMedicationStrength(medicationDetails.getMedicationStrength());
return medicationDetailsRepo.save(pMedicationDetails);
}



@Override
public void deleteMedication(Integer medicationId) {
MedicationDetails medicationDetails = getMedicationDetails(medicationId);
medicationDetailsRepo.delete(medicationDetails);
}



@Override
public List<MedicationDetails> getMedicationbyform(String medicationform) throws MedicationDetailsException {
	// TODO Auto-generated method stub
	return medicationDetailsRepo.findByMedicationForm(medicationform);
	//return null;
}



@Override
public List<MedicationDetails> getMedicationbyname(String medicationname) throws MedicationDetailsException {
	// TODO Auto-generated method stub
	return medicationDetailsRepo.findByMedicationGenericName(medicationname);
}
}

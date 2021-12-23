package com.ct.ghospital.patient.serviceimpl;

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
    public MedicationDetails getMedicationDetails(Integer medicationId) throws Exception {
        Optional<MedicationDetails> medicationDetailsOptional = medicationDetailsRepo.findById(medicationId);
        if (medicationDetailsOptional.isPresent()) {
            return medicationDetailsOptional.get();
        } else {
            throw new Exception("Medication is not present");
        }
    }

    @Override
    public MedicationDetails saveMedicationDetails(MedicationDetails medicationDetails) {
        return medicationDetailsRepo.save(medicationDetails);
    }

    @Override
    public MedicationDetails updateMedicationDetails(Integer medicationId, MedicationDetails medicationDetails) throws Exception {
        MedicationDetails pMedicationDetails = getMedicationDetails(medicationId);
        pMedicationDetails.setMedicationCode(medicationDetails.getMedicationCode());
        pMedicationDetails.setMedicationName(medicationDetails.getMedicationName());
        pMedicationDetails.setMedicationDescription(medicationDetails.getMedicationDescription());
        return medicationDetailsRepo.save(pMedicationDetails);
    }

    @Override
    public void deleteMedication(Integer medicationId) throws Exception {
        MedicationDetails medicationDetails = getMedicationDetails(medicationId);
        medicationDetailsRepo.delete(medicationDetails);
    }
}

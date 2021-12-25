package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.PatientAllergicDetailsException;
import com.ct.ghospital.patient.model.PatientAllergyDetails;
import com.ct.ghospital.patient.repo.PatientAllergicDetailsRepo;
import com.ct.ghospital.patient.service.PatientAllergicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientAllergicDetailsServiceImpl implements PatientAllergicDetailsService {

    @Autowired
    private PatientAllergicDetailsRepo patientAllergicDetailsRepo;

    @Override
    public List<PatientAllergyDetails> getAllPatientAllergicDetails() {
        return new ArrayList<>(patientAllergicDetailsRepo.findAll());
    }

    @Override
    public PatientAllergyDetails getPatientAllergicDetails(Integer patientallergicid) {
        Optional<PatientAllergyDetails> patientAllergyDetailsOptional = patientAllergicDetailsRepo.findById(patientallergicid);
        if (patientAllergyDetailsOptional.isPresent()) {
            return patientAllergyDetailsOptional.get();
        } else {
            throw new PatientAllergicDetailsException("Patient Allergic Details With Id " + patientallergicid + " is not available");
        }
    }

    @Override
    public PatientAllergyDetails savePatientAllergicDetails(PatientAllergyDetails patientAllergyDetails) {
        return patientAllergicDetailsRepo.save(patientAllergyDetails);
    }

    @Override
    public PatientAllergyDetails updatePatientAllergicDetails(Integer patientallergicid, PatientAllergyDetails patientAllergyDetails) {
        PatientAllergyDetails pPatientAllergyDetails = getPatientAllergicDetails(patientallergicid);
        pPatientAllergyDetails.setStatus(patientAllergyDetails.getStatus());
        pPatientAllergyDetails.setFatal(patientAllergyDetails.getFatal());
        pPatientAllergyDetails.setPatient(patientAllergyDetails.getPatient());
        pPatientAllergyDetails.setAllergicDetails(patientAllergyDetails.getAllergicDetails());
        return patientAllergicDetailsRepo.save(pPatientAllergyDetails);
    }

    @Override
    public void deletePatientAllergicDetails(Integer patientallergicid) {
        PatientAllergyDetails patientAllergyDetails = getPatientAllergicDetails(patientallergicid);
        patientAllergicDetailsRepo.delete(patientAllergyDetails);
    }
}

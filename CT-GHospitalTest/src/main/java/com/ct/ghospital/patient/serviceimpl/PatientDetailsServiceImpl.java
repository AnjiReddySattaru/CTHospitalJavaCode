package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.dto.PatientDetailsDTO;
import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.model.PatientAllergyDetails;
import com.ct.ghospital.patient.model.PatientDetails;
import com.ct.ghospital.patient.repo.AllergicDetailsRepo;
import com.ct.ghospital.patient.repo.PatientAllergicDetailsRepo;
import com.ct.ghospital.patient.repo.PatientDetailsRepo;
import com.ct.ghospital.patient.service.AllergicDetailsService;
import com.ct.ghospital.patient.service.PatientDetailsService;
import com.ct.ghospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    @Autowired
    private PatientAllergicDetailsRepo patientAllergicDetailsRepo;

    @Autowired
    PatientService patientService;

    @Autowired
    AllergicDetailsService allergicDetailsService;

    @Autowired
    AllergicDetailsRepo allergicDetailsRepo;

    @Override
    public PatientDetailsDTO savePatientAndAllergicDetails(PatientDetailsDTO patientDetailsDTO) {
        PatientDetailsDTO response = new PatientDetailsDTO();
        PatientDetails pPatinetDetails = patientDetailsDTO.getPatientDetails();
        Patient patient = null;
        try {
            patient=patientService.getPatientById(pPatinetDetails.getPatient().getPatientId());
            pPatinetDetails.setPatient(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setPatientDetails(patientDetailsRepo.save(pPatinetDetails));
        for (PatientAllergyDetails patientAllergyDetails : patientDetailsDTO.getPatientAllergyDetailsList()) {
            try {
                AllergicDetails allergicDetails = allergicDetailsService.getAllergicDetails(patientAllergyDetails.getAllergicDetails().getAllergyId());
                patientAllergyDetails.setAllergicDetails(allergicDetails);
                patientAllergyDetails.setPatient(patient);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.setPatientAllergyDetailsList(patientAllergicDetailsRepo.saveAll(patientDetailsDTO.getPatientAllergyDetailsList()));
        return response;
    }

    @Override
    public List<PatientDetailsDTO> getAllPatientAndAllergicDetails() {
        List<PatientDetailsDTO> patientDetailsDTOList = new ArrayList<>();
        patientDetailsRepo.findAll().forEach(patientDetails -> {
            PatientDetailsDTO patientDetailsDTO = new PatientDetailsDTO();
            patientDetailsDTO.setPatientDetails(patientDetails);
            patientDetailsDTO.setPatientAllergyDetailsList(patientAllergicDetailsRepo.findByPatientPatientId(patientDetails.getPatient().getPatientId()));
            patientDetailsDTOList.add(patientDetailsDTO);
        });
        return patientDetailsDTOList;
    }

    @Override
    public PatientDetailsDTO getPatientAndAllergicDetails(Integer patientId) {

        PatientDetailsDTO patientDetailsDTO = new PatientDetailsDTO();

        patientDetailsDTO.setPatientDetails(patientDetailsRepo.findByPatientPatientId(patientId));
        patientDetailsDTO.setPatientAllergyDetailsList(patientAllergicDetailsRepo.findByPatientPatientId(patientId));
        return patientDetailsDTO;
    }

    @Override
    public PatientDetailsDTO updatePatientAndAllergicDetails(Integer patient_id, PatientDetailsDTO patientDetailsDTO) throws Exception {
        patientService.getPatientById(patient_id);
        PatientDetailsDTO patientDetailsDTO1 = new PatientDetailsDTO();
        patientDetailsDTO1.setPatientDetails(patientDetailsRepo.findByPatientPatientId(patient_id));
        patientDetailsDTO1.setPatientAllergyDetailsList(patientAllergicDetailsRepo.findByPatientPatientId(patient_id));
        patientDetailsDTO1.setPatientDetails(patientDetailsRepo.save(patientDetailsDTO1.getPatientDetails()));
        patientDetailsDTO1.setPatientAllergyDetailsList(patientAllergicDetailsRepo.saveAll(patientDetailsDTO1.getPatientAllergyDetailsList()));
        return patientDetailsDTO1;
    }

    @Override
    public void deletePatientAndAllergicDetails(Integer patient_id) throws Exception {
        patientService.getPatientById(patient_id);
        patientDetailsRepo.delete(patientDetailsRepo.findByPatientPatientId(patient_id));
        patientAllergicDetailsRepo.deleteAll(patientAllergicDetailsRepo.findByPatientPatientId(patient_id));
    }
}

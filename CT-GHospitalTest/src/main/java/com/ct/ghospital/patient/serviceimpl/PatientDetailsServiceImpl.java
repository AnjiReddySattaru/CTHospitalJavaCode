package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.dto.PatientDetailsDTO;
import com.ct.ghospital.patient.exception.PatientAllergicDetailsException;
import com.ct.ghospital.patient.exception.PatientDetailsExceptions;
import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.*;
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

    @Override
    public PatientDetailsDTO savePatientAndAllergicDetails(PatientDetailsDTO patientDetailsDTO) {
        PatientDetailsDTO response = new PatientDetailsDTO();
        PatientDetails pPatinetDetails = patientDetailsDTO.getPatientDetails();
        Patient patient = null;
        try {
            patient = patientService.getPatientById(pPatinetDetails.getPatient().getPatientId());
            pPatinetDetails.setPatient(patient);
        } catch (PatientDetailsExceptions ex) {
            throw new PatientDetailsExceptions("Patient is not present to save details");
        }
        response.setPatientDetails(patientDetailsRepo.save(pPatinetDetails));
        for (PatientAllergyDetails patientAllergyDetails : patientDetailsDTO.getPatientAllergyDetailsList()) {
            try {
                AllergicDetails allergicDetails = allergicDetailsService.getAllergicDetails(patientAllergyDetails.getAllergicDetails().getAllergyId());
                patientAllergyDetails.setAllergicDetails(allergicDetails);
                patientAllergyDetails.setPatient(patient);
            } catch (PatientAllergicDetailsException ex) {
                throw new PatientAllergicDetailsException("Patient Allergy Id is not present to save Allergic Details to Patient");
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

    /*@Override
    public PatientDetailsDTO updatePatientAndAllergicDetails(Integer patient_id, PatientDetailsDTO patientDetailsDTO) {
        patientService.getPatientById(patient_id);
        PatientDetailsDTO patientDetailsDTO1 = new PatientDetailsDTO();
        patientDetailsDTO1.setPatientDetails(patientDetailsRepo.findByPatientPatientId(patient_id));
        patientDetailsDTO1.setPatientAllergyDetailsList(patientAllergicDetailsRepo.findByPatientPatientId(patient_id));
        patientDetailsDTO1.setPatientDetails(patientDetailsRepo.save(patientDetailsDTO1.getPatientDetails()));
        patientDetailsDTO1.setPatientAllergyDetailsList(patientAllergicDetailsRepo.saveAll(patientDetailsDTO1.getPatientAllergyDetailsList()));
        return patientDetailsDTO1;
    }*/
    @Override
    public PatientDetailsDTO updatePatientAndAllergicDetails(Integer patient_id, PatientDetailsDTO patientDetailsDTO) {
        PatientDetails patientDetails=patientDetailsRepo.findByPatientPatientId(patient_id);
        /*Updating Patient Details if any changes*/
        Patient patient = patientDetails.getPatient();
        patient.setTitle(patientDetailsDTO.getPatientDetails().getPatient().getTitle());
        patient.setFirstName(patientDetailsDTO.getPatientDetails().getPatient().getFirstName());
        patient.setLastName(patientDetailsDTO.getPatientDetails().getPatient().getLastName());
        patient.setDateOfBirth(patientDetailsDTO.getPatientDetails().getPatient().getDateOfBirth());
        patient.setMailId(patientDetailsDTO.getPatientDetails().getPatient().getMailId());
        patient.setContactNumber(patientDetailsDTO.getPatientDetails().getPatient().getContactNumber());
        /*Updating Address Details if any changes */
        Address address = patientDetails.getAddress();
        address.setHomeAddress(patientDetailsDTO.getPatientDetails().getAddress().getHomeAddress());
        address.setCountry(patientDetailsDTO.getPatientDetails().getAddress().getCountry());
        address.setState(patientDetailsDTO.getPatientDetails().getAddress().getState());
        address.setPostalCode(patientDetailsDTO.getPatientDetails().getAddress().getPostalCode());
       // address.setPhoneNumber(patientDetailsDTO.getPatientDetails().getAddress().getPhoneNumber());
        /*Update Emergency Contact Details if any changes */
        EmergencyContact emergencyContact = patientDetails.getEmergencyContact();
        /*Getting Address Details from Emergency Contact */
        Address eAddress = patientDetails.getEmergencyContact().getAddress();
        eAddress.setHomeAddress(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAddress().getHomeAddress());
        eAddress.setCountry(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAddress().getCountry());
        eAddress.setState(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAddress().getState());
        eAddress.setPostalCode(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAddress().getPostalCode());
        //eAddress.setPhoneNumber(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAddress().getPhoneNumber());
        emergencyContact.setFirstName(patientDetailsDTO.getPatientDetails().getEmergencyContact().getFirstName());
        emergencyContact.setLastName(patientDetailsDTO.getPatientDetails().getEmergencyContact().getLastName());
        emergencyContact.setAddress(eAddress);
        emergencyContact.setEmail(patientDetailsDTO.getPatientDetails().getEmergencyContact().getEmail());
        emergencyContact.setRelationship(patientDetailsDTO.getPatientDetails().getEmergencyContact().getRelationship());
        emergencyContact.setAccessToPortal(patientDetailsDTO.getPatientDetails().getEmergencyContact().getAccessToPortal());
        /*Update Patinet Details Class fields */
        //PatientDetails patientDetails = new PatientDetails();
        patientDetails.setGender(patientDetailsDTO.getPatientDetails().getGender());
        patientDetails.setAge(patientDetailsDTO.getPatientDetails().getAge());
        patientDetails.setRace(patientDetailsDTO.getPatientDetails().getRace());
        patientDetails.setEthnicity(patientDetailsDTO.getPatientDetails().getEthnicity());
        patientDetails.setLanguagesKnown(patientDetailsDTO.getPatientDetails().getLanguagesKnown());
        patientDetails.setPatient(patient);
        patientDetails.setAddress(address);
        patientDetails.setEmergencyContact(emergencyContact);
        patientDetailsRepo.save(patientDetails);
        PatientDetailsDTO pPatientDetailsDTO = new PatientDetailsDTO();
        pPatientDetailsDTO.setPatientDetails(patientDetails);
        for (PatientAllergyDetails patientAllergyDetails : patientDetailsDTO.getPatientAllergyDetailsList()) {
            try {
                AllergicDetails allergicDetails = allergicDetailsService.getAllergicDetails(patientAllergyDetails.getAllergicDetails().getAllergyId());
                patientAllergyDetails.setAllergicDetails(allergicDetails);
                patientAllergyDetails.setPatient(patient);
            } catch (PatientAllergicDetailsException ex) {
                throw new PatientAllergicDetailsException("Patient Allergy Id is not present to save Allergic Details to Patient");
            }
        }
        pPatientDetailsDTO.setPatientAllergyDetailsList(patientAllergicDetailsRepo.saveAll(patientDetailsDTO.getPatientAllergyDetailsList()));
        return pPatientDetailsDTO;
    }

    @Override
    public void deletePatientAndAllergicDetails(Integer patient_id) {
        try {
            patientService.getPatientById(patient_id);
            patientDetailsRepo.delete(patientDetailsRepo.findByPatientPatientId(patient_id));
            patientAllergicDetailsRepo.deleteAll(patientAllergicDetailsRepo.findByPatientPatientId(patient_id));
        } catch (PatientDetailsExceptions ex) {
            throw new PatientExceptions("Patient With Id " + patient_id + " is not Present to Delete");
        }

    }
}

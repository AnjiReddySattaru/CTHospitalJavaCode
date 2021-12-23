package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.EmergencyContact;

import java.util.List;

public interface EmergencyContactService {
    List<EmergencyContact> getAllEmergencyContactDetails();

    EmergencyContact getEmergencyContactDetails(Integer id) throws Exception;

    EmergencyContact saveEmergencyContact(EmergencyContact emergencyContact);

    EmergencyContact updateEmergencyContact(Integer id,EmergencyContact emergencyContact) throws Exception;

    void deleteEmergencyContact(Integer id) throws Exception;
}

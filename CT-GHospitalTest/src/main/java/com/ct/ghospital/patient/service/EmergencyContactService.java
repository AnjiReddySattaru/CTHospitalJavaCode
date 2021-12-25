package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.EmergencyContactException;
import com.ct.ghospital.patient.model.EmergencyContact;

import java.util.List;

public interface EmergencyContactService {
    List<EmergencyContact> getAllEmergencyContactDetails();

    EmergencyContact getEmergencyContactDetails(Integer id) throws EmergencyContactException;

    EmergencyContact saveEmergencyContact(EmergencyContact emergencyContact);

    EmergencyContact updateEmergencyContact(Integer id, EmergencyContact emergencyContact) throws EmergencyContactException;

    void deleteEmergencyContact(Integer id) throws EmergencyContactException;
}

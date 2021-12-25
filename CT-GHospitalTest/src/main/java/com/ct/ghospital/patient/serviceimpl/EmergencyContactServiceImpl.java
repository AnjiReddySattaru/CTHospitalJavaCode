package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.EmergencyContactException;
import com.ct.ghospital.patient.model.EmergencyContact;
import com.ct.ghospital.patient.repo.EmergencyContactRepo;
import com.ct.ghospital.patient.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {
    @Autowired
    private EmergencyContactRepo emergencyContactRepo;

    @Override
    public List<EmergencyContact> getAllEmergencyContactDetails() {
        return new ArrayList<>(emergencyContactRepo.findAll());
    }

    @Override
    public EmergencyContact getEmergencyContactDetails(Integer emergencyid) {
        Optional<EmergencyContact> emergencyContact = emergencyContactRepo.findById(emergencyid);
        if (emergencyContact.isPresent()) {
            return emergencyContact.get();
        } else {
            throw new EmergencyContactException("Emergency Contact With Id" + emergencyid + "is Not Found");
        }
    }

    @Override
    public EmergencyContact saveEmergencyContact(EmergencyContact emergencyContact) {
        return emergencyContactRepo.save(emergencyContact);
    }

    @Override
    public EmergencyContact updateEmergencyContact(Integer emergencyid, EmergencyContact emergencyContact) {
        EmergencyContact pEmergencyContact = getEmergencyContactDetails(emergencyid);
        try {
            pEmergencyContact.setFirstName(emergencyContact.getFirstName());
            pEmergencyContact.setLastName(emergencyContact.getLastName());
            pEmergencyContact.setEmail(emergencyContact.getEmail());
            pEmergencyContact.setAddress(emergencyContact.getAddress());
            pEmergencyContact.setRelationship(emergencyContact.getRelationship());
            pEmergencyContact.setPhoneNumber(emergencyContact.getPhoneNumber());
            pEmergencyContact.setAccessToPortal(emergencyContact.getAccessToPortal());
            return emergencyContactRepo.save(pEmergencyContact);
        } catch (EmergencyContactException ex) {
            throw new EmergencyContactException(ex.getMessage());
        }
    }

    @Override
    public void deleteEmergencyContact(Integer emergencyid) {
        EmergencyContact emergencyContact = getEmergencyContactDetails(emergencyid);
        emergencyContactRepo.delete(emergencyContact);
    }
}

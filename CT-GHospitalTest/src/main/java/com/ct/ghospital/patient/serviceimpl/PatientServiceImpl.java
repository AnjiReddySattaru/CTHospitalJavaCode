package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.repo.PatientRepository;
import com.ct.ghospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return new ArrayList<>(patientRepository.findAll());
    }

    @Override
    public Patient getPatientById(Integer patientid) {
        Optional<Patient> patient = patientRepository.findById(patientid);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new PatientExceptions("Patient With Id " + patientid + " is Not Present");
        }
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer patientid) {
        patientRepository.delete(getPatientById(patientid));
    }

    @Override
    public Patient update(Integer patientid, Patient patients) {
        Patient patient = getPatientById(patientid);
        patient.setTitle(patients.getTitle());
        patient.setFirstName(patients.getFirstName());
        patient.setLastName(patients.getLastName());
        patient.setMailId(patients.getMailId());
        patient.setDateOfBirth(patients.getDateOfBirth());
        patient.setContactNumber(patients.getContactNumber());
        patient.setPassword(patients.getPassword());
        patient.setConfirmPassword(patients.getConfirmPassword());
        return patientRepository.save(patient);
    }
}

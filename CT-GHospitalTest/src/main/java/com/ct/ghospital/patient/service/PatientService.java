package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatient() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    public Patient getPatientById(Integer id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new Exception("Patient is Not Present");
        }
    }

    public Patient saveOrUpdate(Patient patient) {
        return patientRepository.save(patient);
    }

    public void delete(Integer patientid) throws Exception {
        Patient patient = getPatientById(patientid);
        patientRepository.delete(patient);
    }

    public Patient update(Integer patientid, Patient patients) throws Exception {
        Patient patient = getPatientById(patientid);
        patientRepository.save(patients);
        return patients;
    }
}

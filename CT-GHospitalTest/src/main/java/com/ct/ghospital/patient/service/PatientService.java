package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.dto.PatientDashboardDTO;
import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;

import java.util.List;
import java.util.Optional;

import org.keycloak.representations.AccessTokenResponse;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientById(long patientId) throws PatientExceptions;
    Patient saveOrUpdate(Patient patient);
    Patient update(Integer patientid, Patient patients) throws PatientExceptions;
    void deletePatient(Integer patientid) throws PatientExceptions;
    
    public ServiceResponse createPatient(Patient PatientRegistartionBean);
	public boolean checkEmailExist(String email);
	public Patient checkLogin(String emailId , String password);
	public List<PatientDashboardDTO> employeeListbyStatus(char status) ;
	
	public Boolean updatePatientStatus(long l, char status);
	
	public Boolean resetPatientPassword(long employeeId);
	
	public String getToken(String username, String password);
	
	public AccessTokenResponse getTokenObject(String username, String password);
}

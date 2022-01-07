package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.repo.PatientRepository;
import com.ct.ghospital.patient.service.PatientService;
import com.ct.ghospital.patient.service.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return new ArrayList<>(patientRepository.findAll());
    }

    @Override
    public Patient getPatientById(long patientid) {
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
        patient.setEmailId(patients.getEmailId());
        patient.setDob(patients.getDob());
        patient.setContactNumber(patients.getContactNumber());
        patient.setPassword(patients.getPassword());
        patient.setConfirmPassword(patients.getConfirmPassword());
        return patientRepository.save(patient);
    }



    public ServiceResponse createPatient(Patient patientRegistartionBean) {
		// TODO Auto-generated method stub
		
	//	System.out.println(repo.findAll());
		if(!checkEmailExist(patientRegistartionBean.getEmailId()))
		{	
			if(patientRegistartionBean.getPassword().equals(patientRegistartionBean.getConfirmPassword()))
				
			{
					try
					{
						patientRegistartionBean.setFirstLogin(50);//workaround
						
						patientRepository.save(patientRegistartionBean);
					}catch(Exception e)
					{
						return ServiceResponse.Error;
					}
					
					return ServiceResponse.RegistrationSuccess;
				
			}else
			{
				return ServiceResponse.passwordNotMatched;
			}
			
		}else
		{
			return ServiceResponse.EmailExist;
		}
		
	
	}
    
  
	@Override
	public boolean checkEmailExist(String email) {
		// TODO Auto-generated method stub
		return patientRepository.existsByEmailId(email);
	}


	
	public Patient checkLogin(String emailId , String password) {
		Patient p = patientRepository.findByEmailId(emailId);
		System.out.println("this is employee" + p);
		if(p != null)
		{
			if(p.getPassword().equals(password)) {
				return p;
			}
			else 
				return null;
		}
		else return null;
		
	}
}





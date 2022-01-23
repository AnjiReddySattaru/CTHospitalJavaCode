package com.ct.ghospital.patient.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.ghospital.configuration.AuthService;
import com.ct.ghospital.patient.dto.PatientDashboardDTO;
import com.ct.ghospital.patient.exception.PatientExceptions;
import com.ct.ghospital.patient.exception.StatusCheckException;
import com.ct.ghospital.patient.exception.UnauthorizedcheckException;
import com.ct.ghospital.patient.exception.UserNotFoundException;
import com.ct.ghospital.patient.exception.WrongCrendentials;
import com.ct.ghospital.patient.model.Patient;
import com.ct.ghospital.patient.repo.PatientRepository;
import com.ct.ghospital.patient.service.PatientService;
import com.ct.ghospital.patient.service.ServiceResponse;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AuthService authservice;

	@Override
	public List<Patient> getAllPatient() {
		return new ArrayList<>(patientRepository.findAll());
	}

	private final RestTemplate restTemplate;

	public PatientServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
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

		// System.out.println(repo.findAll());
		if (!checkEmailExist(patientRegistartionBean.getEmailId())) {
			if (patientRegistartionBean.getPassword().equals(patientRegistartionBean.getConfirmPassword())){

					try
					{
						patientRegistartionBean.setFirstLogin(100);//workaround
						
						patientRepository.save(patientRegistartionBean);
						authservice.registerUser(patientRegistartionBean.getEmailId(),patientRegistartionBean.getPassword(),patientRegistartionBean.getFirstName(),patientRegistartionBean.getLastName());
					}catch(Exception e)
					{
						return ServiceResponse.Error;
					}
					
					return ServiceResponse.RegistrationSuccess;
				
			}else
			{
				return ServiceResponse.passwordNotMatched;
			}

		} else {
			return ServiceResponse.EmailExist;
		}

	}

	@Override
	public boolean checkEmailExist(String email) {
		// TODO Auto-generated method stub
		return patientRepository.existsByEmailId(email);
	}

	public Patient checkLogin(String emailId, String password) {
		String token = getToken(emailId, password);
		
//		Patient p = patientRepository.findByEmailId(emailId);
//		System.out.println("this is employee" + p);
//		if (p != null) {
//			if (p.getPassword().equals(password)) {
//				return p;
//			} else
//				return null;
//		} else
//			return null;
		
		if (token != null) {
			System.out.println(token);
			Patient p = patientRepository.findByEmailId(emailId);
			System.out.println("this is employee" + p);
			if (p != null) {
				if (p.getPassword().equals(password)) {
					if (p.getStatus() == 'A')
						return p;
					else
						throw new StatusCheckException();
				} else
					throw new WrongCrendentials();
			} else
				throw new UserNotFoundException();
		} else {
			throw new UnauthorizedcheckException();
		}
		
		
		
		

	}
	
	public String getToken(String username, String password) {
		try
		{
			return authservice.getUser(username, password).getToken();
		}catch(Exception e)
		{
			throw new UserNotFoundException();
			
		}
	
	}
	
	public AccessTokenResponse getTokenObject(String username, String password) {
		try
		{
			return authservice.getUser(username, password);
		}catch(Exception e)
		{
			throw new UserNotFoundException();
			
		}
	
	}

	public List<PatientDashboardDTO> employeeListbyStatus(char status) {

		List<Patient> patientList = patientRepository.patientByStatusList(status);

		List<PatientDashboardDTO> patientdashboarddto = new ArrayList<>();

		for (Patient patient : patientList) {
			PatientDashboardDTO pdto = new PatientDashboardDTO();
			pdto.setFirstName(patient.getFirstName());
			pdto.setLastName(patient.getLastName());
			pdto.setId(patient.getId());
//			patient.getDob();
			pdto.setDob(patient.getDob().toString());
			// pdto.setDob(patient.getDob());
			pdto.setEmailId(patient.getEmailId());
			pdto.setTitle(patient.getTitle());
			pdto.setStatus(patient.getStatus());

			patientdashboarddto.add(pdto);
		}

		return patientdashboarddto;
	}

	public Boolean updatePatientStatus(long patientId, char status) {

		Patient pt = getPatientById(patientId);

		if (pt != null) {

			pt.setStatus(status);

			Patient afterStatus = patientRepository.save(pt);
			if (afterStatus == null)
				return false;
			else
				return true;
		} else
			return false;

	}
	

	public Boolean resetPatientPassword(long employeeId) {
		System.out.println("In Update Empoyee Status service" + employeeId );

		Optional<Patient> check = patientRepository.findById((long)employeeId);
		if (check.isPresent()) {
			Patient patient = patientRepository.findById((long)employeeId).get();
		
			patient.setPassword("Password123@");
			
			Patient after  = patientRepository.save(patient);
			
			if (after == null)
				return false;
			else
				return true;
		} else
			return false;
	}

	public List<Object[]>  countByStatus(){
//		HashMap<Character,Integer> map = new HashMap<>();
//				map = employeerepository.countEmployee();
//				map.entrySet().forEach(entry -> {
//				    System.out.println(entry.getKey() + " " + entry.getValue());
//				}); 
				return patientRepository.countPatient();
	}

}

package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.VitalSignsException;
import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.repo.VitalSignsRepo;
import com.ct.ghospital.patient.service.PatientService;
import com.ct.ghospital.patient.service.VitalSignsService;
import com.ct.ghospital.util.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VitalSignsServiceImpl implements VitalSignsService {

	@Autowired
	private final VitalSignsRepo vitalSignsRepo;

	@Autowired
	private final PatientService patientService;

	public VitalSignsServiceImpl(VitalSignsRepo vitalSignsRepo, PatientService patientService) {
		this.vitalSignsRepo = vitalSignsRepo;
		this.patientService = patientService;
	}

	@Override
	public List<VitalSigns> getAllVitalSignsDetails() {
		return new ArrayList<>(vitalSignsRepo.findAll());
	}

	@Override
	public VitalSigns getVitalSignsDetails(long patientId) {
		Optional<VitalSigns> vitalSignsOptional = Optional
				.ofNullable(vitalSignsRepo.findByPatientIdAndStatus(patientId, Status.A));
		if (vitalSignsOptional.isPresent()) {
			return vitalSignsOptional.get();
		} else {
			throw new VitalSignsException("Vital Signs Active With Id " + patientId + " is not present");
		}
	}

	@Override
	public VitalSigns saveVitalSignsDetails(VitalSigns vitalSigns) {
		vitalSigns.setPatient(patientService.getPatientById(vitalSigns.getPatient().getId()));
		return vitalSignsRepo.save(vitalSigns);
	}

	@Override
	public VitalSigns updateVitalSignsDetails(long patientId, VitalSigns vitalSigns) {
		VitalSigns pvitalSigns = getVitalSignsDetails(patientId);
		pvitalSigns.setPatient(patientService.getPatientById(patientId));
		pvitalSigns.setHeight(vitalSigns.getHeight());
		pvitalSigns.setWeight(vitalSigns.getWeight());
		pvitalSigns.setBloodPressure(vitalSigns.getBloodPressure());
		pvitalSigns.setBodyTemperature(vitalSigns.getBodyTemperature());
		pvitalSigns.setVisitDate(vitalSigns.getVisitDate());
		pvitalSigns.setRespirationRate(vitalSigns.getRespirationRate());
		pvitalSigns.setStatus(vitalSigns.getStatus());
		return vitalSignsRepo.save(pvitalSigns);
	}

	@Override
	public void deleteVitalSigns(long vitalsignsid) {
		VitalSigns vitalSigns = getVitalSignsDetails(vitalsignsid);
		vitalSignsRepo.delete(vitalSigns);
	}
}
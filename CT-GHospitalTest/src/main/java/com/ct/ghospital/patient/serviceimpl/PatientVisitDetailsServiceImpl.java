package com.ct.ghospital.patient.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.ghospital.patient.exception.PatientVisitDetailsException;
import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.model.MedicationDetails;
import com.ct.ghospital.patient.model.PatientVisitDetails;
import com.ct.ghospital.patient.model.ProceduresDetails;
import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.repo.PatientVisitDetailsRepo;
import com.ct.ghospital.patient.service.DiagnosisDetailsService;
import com.ct.ghospital.patient.service.MedicationDetailsService;
import com.ct.ghospital.patient.service.PatientService;
import com.ct.ghospital.patient.service.PatientVisitDetailsService;
import com.ct.ghospital.patient.service.ProcedureDetailsService;
@Service
public class PatientVisitDetailsServiceImpl implements PatientVisitDetailsService {

	@Autowired
	private PatientService patientService;



	@Autowired
	private PatientVisitDetailsRepo patientVisitDetailsRepo;



	@Autowired
	private ProcedureDetailsService procedureDetailsService;



	@Autowired
	private DiagnosisDetailsService diagnosisDetailsService;



	@Autowired
	private MedicationDetailsService medicationDetailsService;



	@Override
	public List<PatientVisitDetails> getAllVisitDetails(Integer patientId) {
	return patientVisitDetailsRepo.findAll().stream().filter(patientVisitDetails -> patientVisitDetails.getPatient().getPatientId().equals(patientId)).collect(Collectors.toList());
	}



	@Override
	public PatientVisitDetails getVisitDetails(Integer patientVisitId) throws PatientVisitDetailsException {
	Optional<PatientVisitDetails> patientVisitDetailsOptional = patientVisitDetailsRepo.findById(patientVisitId);
	if (patientVisitDetailsOptional.isPresent()) {
	return patientVisitDetailsOptional.get();
	} else {
	throw new PatientVisitDetailsException("Visit Details with Id "+patientVisitId+" is not present");
	}
	}



	@Override
	public PatientVisitDetails savePatientVisitDetails(PatientVisitDetails patientVisitDetails) {
	patientVisitDetails.setPatient(patientService.getPatientById(patientVisitDetails.getPatient().getPatientId()));
	patientVisitDetails.setVitalSigns(patientVisitDetails.getVitalSigns());
	List<DiagnosisDetails> diagnosisDetailsList = new ArrayList<>();
	for (DiagnosisDetails d : patientVisitDetails.getDiagnosisDetails()) {
	diagnosisDetailsList.add(diagnosisDetailsService.getDiagnosisDetails(d.getDiagnosisId()));
	}
	patientVisitDetails.setDiagnosisDetails(diagnosisDetailsList);
	List<ProceduresDetails> proceduresDetailsList = new ArrayList<>();
	for (ProceduresDetails p : patientVisitDetails.getProceduresDetails()) {
	proceduresDetailsList.add(procedureDetailsService.getProcedureDetails(p.getProceduresId()));
	}
	patientVisitDetails.setProceduresDetails(proceduresDetailsList);
	List<MedicationDetails> medicationDetailsList = new ArrayList<>();
	for (MedicationDetails m : patientVisitDetails.getMedicationDetails()) {
	medicationDetailsList.add(medicationDetailsService.getMedicationDetails(m.getMedicationId()));
	}
	patientVisitDetails.setMedicationDetails(medicationDetailsList);
	patientVisitDetails.setStatus(patientVisitDetails.getStatus());
	return patientVisitDetailsRepo.save(patientVisitDetails);
	}



	@Override
	public PatientVisitDetails updateVisitDetails(Integer patientVisitId, PatientVisitDetails patientVisitDetails) throws PatientVisitDetailsException {
	PatientVisitDetails pPatientVisitDetails = getVisitDetails(patientVisitId);
	VitalSigns vitalSigns = new VitalSigns();
	vitalSigns.setHeight(patientVisitDetails.getVitalSigns().getHeight());
	vitalSigns.setWeight(patientVisitDetails.getVitalSigns().getWeight());
	vitalSigns.setBloodPressure(patientVisitDetails.getVitalSigns().getBloodPressure());
	vitalSigns.setBodyTemperature(patientVisitDetails.getVitalSigns().getBodyTemperature());
	vitalSigns.setRespirationRate(patientVisitDetails.getVitalSigns().getRespirationRate());
	pPatientVisitDetails.setVitalSigns(vitalSigns);
	List<DiagnosisDetails> diagnosisDetailsList = new ArrayList<>();
	for (DiagnosisDetails d : patientVisitDetails.getDiagnosisDetails()) {
	diagnosisDetailsList.add(diagnosisDetailsService.getDiagnosisDetails(d.getDiagnosisId()));
	}
	pPatientVisitDetails.setDiagnosisDetails(diagnosisDetailsList);
	List<ProceduresDetails> proceduresDetailsList = new ArrayList<>();
	for (ProceduresDetails p : patientVisitDetails.getProceduresDetails()) {
	proceduresDetailsList.add(procedureDetailsService.getProcedureDetails(p.getProceduresId()));
	}
	pPatientVisitDetails.setProceduresDetails(proceduresDetailsList);
	List<MedicationDetails> medicationDetailsList = new ArrayList<>();
	for (MedicationDetails m : patientVisitDetails.getMedicationDetails()) {
	medicationDetailsList.add(medicationDetailsService.getMedicationDetails(m.getMedicationId()));
	}
	pPatientVisitDetails.setMedicationDetails(medicationDetailsList);
	pPatientVisitDetails.setStatus(patientVisitDetails.getStatus());
	return patientVisitDetailsRepo.save(pPatientVisitDetails);
	}



	@Override
	public void deleteVisitDetails(Integer patientVisitId) throws PatientVisitDetailsException {
	PatientVisitDetails patientVisitDetails = getVisitDetails(patientVisitId);
	patientVisitDetailsRepo.delete(patientVisitDetails);
	}

}

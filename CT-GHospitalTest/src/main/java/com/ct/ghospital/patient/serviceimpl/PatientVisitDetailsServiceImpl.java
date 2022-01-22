package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.PatientVisitDetailsException;
import com.ct.ghospital.patient.model.*;
import com.ct.ghospital.patient.repo.PatientVisitDetailsRepo;
import com.ct.ghospital.patient.service.*;
import com.ct.ghospital.util.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientVisitDetailsServiceImpl implements PatientVisitDetailsService {

	@Autowired
	private final PatientService patientService;

	@Autowired
	private final VitalSignsService vitalSignsService;

	@Autowired
	private final PatientVisitDetailsRepo patientVisitDetailsRepo;

	@Autowired
	private final ProcedureDetailsService procedureDetailsService;

	@Autowired
	private final DiagnosisDetailsService diagnosisDetailsService;

	@Autowired
	private final MedicationDetailsService medicationDetailsService;

	public PatientVisitDetailsServiceImpl(PatientService patientService, VitalSignsService vitalSignsService,
			PatientVisitDetailsRepo patientVisitDetailsRepo, ProcedureDetailsService procedureDetailsService,
			DiagnosisDetailsService diagnosisDetailsService, MedicationDetailsService medicationDetailsService) {
		this.patientService = patientService;
		this.vitalSignsService = vitalSignsService;
		this.patientVisitDetailsRepo = patientVisitDetailsRepo;
		this.procedureDetailsService = procedureDetailsService;
		this.diagnosisDetailsService = diagnosisDetailsService;
		this.medicationDetailsService = medicationDetailsService;
	}

	@Override
	public List<PatientVisitDetails> getAllVisitDetails(long patientId) {
		return patientVisitDetailsRepo.findAll().stream()
				.filter(patientVisitDetails -> patientVisitDetails.getPatient().getId()==(patientId))
				.filter(patientVisitDetails -> patientVisitDetails.getStatus().equals(Status.I))
				.collect(Collectors.toList());
	}

	@Override
	public PatientVisitDetails getVisitDetails(Integer patientVisitId) throws PatientVisitDetailsException {
		Optional<PatientVisitDetails> patientVisitDetailsOptional = patientVisitDetailsRepo.findById(patientVisitId);
		if (patientVisitDetailsOptional.isPresent()) {
			return patientVisitDetailsOptional.get();
		} else {
			throw new PatientVisitDetailsException("Visit Details with Id " + patientVisitId + " is not present");
		}
	}

	@Override
	public PatientVisitDetails savePatientVisitDetails(PatientVisitDetails patientVisitDetails) {
		patientVisitDetails.setPatient(patientService.getPatientById(patientVisitDetails.getPatient().getId()));
		patientVisitDetails
				.setVitalSigns(vitalSignsService.getVitalSignsDetails(patientVisitDetails.getPatient().getId()));
//Adding List Of Diagnosis
		List<DiagnosisDetails> diagnosisDetailsList = new ArrayList<>();
		for (DiagnosisDetails d : patientVisitDetails.getDiagnosisDetails()) {
			diagnosisDetailsList.add(diagnosisDetailsService.getDiagnosisDetails(d.getDiagnosisId()));
		}
		patientVisitDetails.setDiagnosisDetails(diagnosisDetailsList); // Set Diagnosis Details to Visit From Master
																		// Table Of Diagnosis
//Adding List Of Procedures
		List<ProceduresDetails> proceduresDetailsList = new ArrayList<>();
		for (ProceduresDetails p : patientVisitDetails.getProceduresDetails()) {
			proceduresDetailsList.add(procedureDetailsService.getProcedureDetails(p.getProceduresId()));
		}
		patientVisitDetails.setProceduresDetails(proceduresDetailsList);// Set Procedures Details to Visit From Master
																		// Table Of Diagnosis
//Add List Of Medications
		List<MedicationDetails> medicationDetailsList = new ArrayList<>();
		for (MedicationDetails m : patientVisitDetails.getMedicationDetails()) {
			medicationDetailsList.add(medicationDetailsService.getMedicationDetails(m.getMedicationId()));
		}
		patientVisitDetails.setMedicationDetails(medicationDetailsList);// Set Medications Details to Visit From Master
																		// Table Of Diagnosis
		patientVisitDetails.setStatus(Status.I); // Setting Up the Status for Closing Visit Which is Active By Default
		vitalSignsService
				.updateVitalSignsDetails(patientVisitDetails.getPatient().getId(), patientVisitDetails.getVitalSigns())
				.setStatus(Status.I);
		return patientVisitDetailsRepo.save(patientVisitDetails);
	}

	@Override
	public PatientVisitDetails updateVisitDetails(Integer patientVisitId, PatientVisitDetails patientVisitDetails)
			throws PatientVisitDetailsException {
		PatientVisitDetails pPatientVisitDetails = getVisitDetails(patientVisitId);
		VitalSigns vitalSigns = new VitalSigns();
		vitalSigns.setHeight(patientVisitDetails.getVitalSigns().getHeight());
		vitalSigns.setWeight(patientVisitDetails.getVitalSigns().getWeight());
		vitalSigns.setBloodPressure(patientVisitDetails.getVitalSigns().getBloodPressure());
		vitalSigns.setBodyTemperature(patientVisitDetails.getVitalSigns().getBodyTemperature());
		vitalSigns.setRespirationRate(patientVisitDetails.getVitalSigns().getRespirationRate());
		vitalSigns.setStatus(patientVisitDetails.getVitalSigns().getStatus());
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

	@Override
	public List<PatientVisitDetails> getAllPatientVisit() {
		// TODO Auto-generated method stub
		return patientVisitDetailsRepo.findAll();
		
	}

	@Override
	public PatientVisitDetails getvisitappointment(long patientId, long appointmentId) {
		// TODO Auto-generated method stub
		Optional<PatientVisitDetails> patientVisitDetailsOptional = patientVisitDetailsRepo.findByPatientIdAndAppointmentId(patientId,appointmentId);
		if (patientVisitDetailsOptional.isPresent()) {
			return patientVisitDetailsOptional.get();
		} else {
			throw new PatientVisitDetailsException("Visit Details with Id " + patientId + " is not present");
		}
	}
}
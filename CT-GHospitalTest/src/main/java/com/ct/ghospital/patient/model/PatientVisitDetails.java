package com.ct.ghospital.patient.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ct.ghospital.util.Status;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "patientvisitdetails")
public class PatientVisitDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patientVisitId")
	private Integer patientVisitId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vitalSignsId", referencedColumnName = "vitalSignsId")
	private VitalSigns vitalSigns;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_procedure", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "proceduresId"))
	private List<ProceduresDetails> proceduresDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_diagnosis", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "diagnosisId"))
	private List<DiagnosisDetails> diagnosisDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_medication", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "medicationId"))
	private List<MedicationDetails> medicationDetails;
	
	@Column
	private Status status = Status.A;

	public Integer getPatientVisitId() {
		return patientVisitId;
	}

	public void setPatientVisitId(Integer patientVisitId) {
		this.patientVisitId = patientVisitId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public VitalSigns getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(VitalSigns vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public List<ProceduresDetails> getProceduresDetails() {
		return proceduresDetails;
	}

	public void setProceduresDetails(List<ProceduresDetails> proceduresDetails) {
		this.proceduresDetails = proceduresDetails;
	}

	public List<DiagnosisDetails> getDiagnosisDetails() {
		return diagnosisDetails;
	}

	public void setDiagnosisDetails(List<DiagnosisDetails> diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}

	public List<MedicationDetails> getMedicationDetails() {
		return medicationDetails;
	}

	public void setMedicationDetails(List<MedicationDetails> medicationDetails) {
		this.medicationDetails = medicationDetails;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}

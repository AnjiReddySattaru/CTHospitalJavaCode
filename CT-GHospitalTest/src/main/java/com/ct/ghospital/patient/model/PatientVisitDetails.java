package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.ct.ghospital.util.Status;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "patientvisitdetails")
public class PatientVisitDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patientVisitId")
	private Integer patientVisitId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Patient patient;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vitalSignsId", referencedColumnName = "vitalSignsId")
	private VitalSigns vitalSigns;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_procedure", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "proceduresId"))
	private List<ProceduresDetails> proceduresDetails;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_diagnosis", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "diagnosisId"))
	private List<DiagnosisDetails> diagnosisDetails;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_medication", joinColumns = @JoinColumn(name = "patientVisitId"), inverseJoinColumns = @JoinColumn(name = "medicationId"))
	private List<MedicationDetails> medicationDetails;
	@Column
	private Status status = Status.A;
	@Column(name = "appointmentId")
	private long appointmentId;
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
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
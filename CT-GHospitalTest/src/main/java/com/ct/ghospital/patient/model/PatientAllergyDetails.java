package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.ct.ghospital.util.Status;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PatientAllergyDetails")
public class PatientAllergyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientAllergyId")
    private Integer patientAllergyId;
    @Column(nullable = false)
    private Status status;
    @Column
    private Boolean fatal;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allergyId", referencedColumnName = "allergyId")
    private AllergicDetails allergicDetails;
	public Integer getPatientAllergyId() {
		return patientAllergyId;
	}
	public void setPatientAllergyId(Integer patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Boolean getFatal() {
		return fatal;
	}
	public void setFatal(Boolean fatal) {
		this.fatal = fatal;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public AllergicDetails getAllergicDetails() {
		return allergicDetails;
	}
	public void setAllergicDetails(AllergicDetails allergicDetails) {
		this.allergicDetails = allergicDetails;
	}
    
}

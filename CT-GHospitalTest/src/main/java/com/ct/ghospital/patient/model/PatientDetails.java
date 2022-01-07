package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "patientdetails")
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patientDetailsId")
    private Integer patientDetailsId;
    @Check(constraints = "Gender in ('Male','Female','Other')")
    @NotBlank(message = "Gender is a required field.")
    @Column(nullable = false, length = 6)
    private String gender;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    @NotBlank(message = "Race field cannot be empty.")
    @Min(value = 2, message = "Please don’t use abbreviations")
    private String race;
    @Column(nullable = false)
    @NotBlank(message = "Ethnicity field cannot be empty.")
    @Min(value = 2, message = "Please don’t use abbreviations")
    private String ethnicity;
    @Column(nullable = false)
    @NotBlank(message = "Languages Known cannot be empty")
    @Min(value = 2, message = "Please don’t use abbreviations")
    private String languagesKnown;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_contact_id", referencedColumnName = "emergencyContactId")
    private EmergencyContact emergencyContact;
	public Integer getPatientDetailsId() {
		return patientDetailsId;
	}
	public void setPatientDetailsId(Integer patientDetailsId) {
		this.patientDetailsId = patientDetailsId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getLanguagesKnown() {
		return languagesKnown;
	}
	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

    
}

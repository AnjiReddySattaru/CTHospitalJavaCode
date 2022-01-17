package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "MedicationDetails")
public class MedicationDetails {



@Id
@Column(name = "medicationId")
@NotEmpty(message = "This field cannot be empty")
private Integer medicationId;
@Column(name = "medication_name")
@NotEmpty(message = "This field cannot be empty")
private String medicationName;
@Column(name = "medication_generic_name")
@NotEmpty(message = "This field cannot be empty")
private String medicationGenericName;
@Column(name = "medication_manufacturer_name")
@NotEmpty(message = "This field cannot be empty")
private String medicationManufacturerName;
@Column(name = "medication_form")
@NotEmpty(message = "This field cannot be empty")
private String medicationForm;
@Column(name = "medication_strength")
@NotEmpty(message = "This field cannot be empty")
private String medicationStrength;
public Integer getMedicationId() {
	return medicationId;
}
public void setMedicationId(Integer medicationId) {
	this.medicationId = medicationId;
}
public String getMedicationName() {
	return medicationName;
}
public void setMedicationName(String medicationName) {
	this.medicationName = medicationName;
}
public String getMedicationGenericName() {
	return medicationGenericName;
}
public void setMedicationGenericName(String medicationGenericName) {
	this.medicationGenericName = medicationGenericName;
}
public String getMedicationManufacturerName() {
	return medicationManufacturerName;
}
public void setMedicationManufacturerName(String medicationManufacturerName) {
	this.medicationManufacturerName = medicationManufacturerName;
}
public String getMedicationForm() {
	return medicationForm;
}
public void setMedicationForm(String medicationForm) {
	this.medicationForm = medicationForm;
}
public String getMedicationStrength() {
	return medicationStrength;
}
public void setMedicationStrength(String medicationStrength) {
	this.medicationStrength = medicationStrength;
}



}

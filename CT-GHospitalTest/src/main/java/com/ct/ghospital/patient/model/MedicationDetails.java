package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "MedicationDetails")
public class MedicationDetails {

    @Id
    @Column(name = "medicationId")
    private Integer medicationId;
    @Column
    private String medicationCode;
    @Column
    private String medicationName;
    @Column
    private String medicationDescription;
	public Integer getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}
	public String getMedicationCode() {
		return medicationCode;
	}
	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getMedicationDescription() {
		return medicationDescription;
	}
	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}

    
}

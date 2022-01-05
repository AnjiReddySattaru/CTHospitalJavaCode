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
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "allergydetails")
public class AllergicDetails {

    @Id
    @Column(name = "allergyId", nullable = false, unique = true)
    @NotEmpty(message = "This field cannot be empty")
    private Integer allergyId;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyType;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyName;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyDescription;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyClinicalInformation;
	public Integer getAllergyId() {
		return allergyId;
	}
	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
	}
	public String getAllergyType() {
		return allergyType;
	}
	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	public String getAllergyDescription() {
		return allergyDescription;
	}
	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}
	public String getAllergyClinicalInformation() {
		return allergyClinicalInformation;
	}
	public void setAllergyClinicalInformation(String allergyClinicalInformation) {
		this.allergyClinicalInformation = allergyClinicalInformation;
	}
    
    
}

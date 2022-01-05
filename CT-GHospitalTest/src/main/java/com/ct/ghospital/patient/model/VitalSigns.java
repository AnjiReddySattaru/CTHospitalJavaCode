package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "vitalsigns")
public class VitalSigns {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vitalSignsId")
	private Integer vitalSignsId;
	@Column
	private Integer height;
	@Column
	private Integer weight;
	@Column
	private Integer bloodPressure;
	@Column
	private Integer bodyTemperature;
	@Column
	private Integer respirationRate;
	@Column
	private Date visitDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patientId",referencedColumnName = "patientId")
	private Patient patient;
	
	public Integer getVitalSignsId() {
		return vitalSignsId;
	}
	public void setVitalSignsId(Integer vitalSignsId) {
		this.vitalSignsId = vitalSignsId;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(Integer bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public Integer getBodyTemperature() {
		return bodyTemperature;
	}
	public void setBodyTemperature(Integer bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	public Integer getRespirationRate() {
		return respirationRate;
	}
	public void setRespirationRate(Integer respirationRate) {
		this.respirationRate = respirationRate;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}

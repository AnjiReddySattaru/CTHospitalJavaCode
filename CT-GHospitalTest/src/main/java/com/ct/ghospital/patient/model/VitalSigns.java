package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.ct.ghospital.util.Status;

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
	@NotEmpty(message = "This field cannot be empty")
	private Integer vitalSignsId;
	@Column(name = "height")
	@NotEmpty(message = "This field cannot be empty")
	private Integer height;
	@Column(name = "weight")
	@NotEmpty(message = "This field cannot be empty")
	private Integer weight;
	@Column(name = "blood_pressure")
	@NotEmpty(message = "This field cannot be empty")
	private Integer bloodPressure;
	@Column(name = "body_temperature")
	@NotEmpty(message = "This field cannot be empty")
	private Integer bodyTemperature;
	@Column(name = "respiration_rate")
	@NotEmpty(message = "This field cannot be empty")
	private Integer respirationRate;
	@Column(name = "visit_date")
	private Date visitDate;
	@Column(name = "status")
	private Status status = Status.A;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}

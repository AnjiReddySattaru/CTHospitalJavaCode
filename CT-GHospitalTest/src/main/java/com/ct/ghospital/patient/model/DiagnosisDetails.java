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
@Table(name = "diagnosis")
public class DiagnosisDetails {

    @Id
    @Column(name = "diagnosisId")
    private Integer diagnosisId;
    @Column
    private String diagnosisCode;
    @Column
    private String diagnosisDescription;
    @Column
    private Boolean diagnosisIsDeprecated;
	public Integer getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}
	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}
	public Boolean getDiagnosisIsDeprecated() {
		return diagnosisIsDeprecated;
	}
	public void setDiagnosisIsDeprecated(Boolean diagnosisIsDeprecated) {
		this.diagnosisIsDeprecated = diagnosisIsDeprecated;
	}
    
}

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

}

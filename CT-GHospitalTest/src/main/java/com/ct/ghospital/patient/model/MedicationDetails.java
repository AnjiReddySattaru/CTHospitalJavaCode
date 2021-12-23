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

}

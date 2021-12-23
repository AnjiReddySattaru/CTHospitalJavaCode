package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PatientAllergyDetails")
public class PatientAllergyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patientAllergyId")
    private Integer patientAllergyId;
    @Column
    private Character status;
    @Column
    private Character fatal;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    private AllergicDetails allergicDetails;

}

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientAllergyId")
    private Integer patientAllergyId;
    @Column(nullable = false)
    private Character status;
    @Column
    private Boolean fatal;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allergyId", referencedColumnName = "allergyId")
    private AllergicDetails allergicDetails;

}

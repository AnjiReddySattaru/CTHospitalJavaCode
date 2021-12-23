package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "patientdetails")
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patientDetailsId")
    private Integer patientDetailsId;
    @Column
    private String gender;
    @Column
    private Integer age;
    @Column
    private String race;
    @Column
    private String ethnicity;
    @Column
    private String[] languagesKnown;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_contact_id", referencedColumnName = "emergencyContactId")
    private EmergencyContact emergencyContact;

}

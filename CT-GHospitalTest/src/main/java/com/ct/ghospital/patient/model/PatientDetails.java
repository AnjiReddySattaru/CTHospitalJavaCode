package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    @Check(constraints = "Gender in ('Male','Female','Other')")
    @NotBlank(message = "Gender is a required field.")
    @Column(nullable = false, length = 6)
    private String gender;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    @NotBlank(message = "Race field cannot be empty.")
    @Min(value = 2, message = "Please don’t use abbreviations")
    private String race;
    @Column(nullable = false)
    @NotBlank(message = "Ethnicity field cannot be empty.")
    @Min(value = 2, message = "Please don’t use abbreviations")
    private String ethnicity;
    @Column(nullable = false)
    @NotBlank(message = "Languages Known cannot be empty")
    @Min(value = 2, message = "Please don’t use abbreviations")
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

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
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patientId")
    private Integer patientId;
    @Column
    private String title;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String mailId;
    @Column
    private Date dateOfBirth;
    @Column
    private String contactNumber;
    @Column
    private String password;
    @Column
    private Character status;
    @Column
    private Boolean firstTimeLogin;

}


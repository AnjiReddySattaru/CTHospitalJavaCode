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
@Table(name = "emergencyContact")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emergencyContactId")
    private Integer emergencyContactId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String relationship;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private Boolean accessToPortal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
}

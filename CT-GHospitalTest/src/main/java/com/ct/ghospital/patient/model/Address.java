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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressId")
    private Integer addressId;
    @Column
    private String homeAddress;
    @Column
    private String country;
    @Column
    private String state;
    @Column
    private String postalCode;
    @Column
    private String phoneNumber;

}

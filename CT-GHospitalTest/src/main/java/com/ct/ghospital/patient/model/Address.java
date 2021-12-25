package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Integer addressId;
    @Column
    @NotEmpty(message = "Please provide the postal address")
    @Min(value = 10, message = "Please provide the postal address")
    @Max(value = 50, message = "Maximum length is 50 Characters")
    private String homeAddress;
    @Column(nullable = false)
    @NotEmpty(message = "Please provide the postal address")
    private String country;
    @Column(nullable = false)
    @NotEmpty(message = "Please provide the postal address")
    private String state;
    @Column(nullable = false)
    @NotEmpty(message = "Please provide the postal address")
    private String postalCode;
    @Column(nullable = false)
    @NotEmpty(message = "Please provide the telephone number")
    @Min(value = 7, message = "Please validate the phone number. Telephone number has XX number of digits")
    @Max(value = 10, message = "Please validate the phone number. Telephone number has XX number of digits")
    private String phoneNumber;

}

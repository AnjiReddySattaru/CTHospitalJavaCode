package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "allergydetails")
public class AllergicDetails {

    @Id
    @Column(name = "allergyId", nullable = false, unique = true)
    @NotEmpty(message = "This field cannot be empty")
    private Integer allergyId;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyType;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyName;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyDescription;
    @Column(nullable = false)
    @NotEmpty(message = "This field cannot be empty")
    private String allergyClinicalInformation;
}

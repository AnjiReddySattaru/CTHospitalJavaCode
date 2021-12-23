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
@Table(name = "allergydetails")
public class AllergicDetails {

    @Id
    @Column(name = "allergyId")
    private Integer allergyId;
    @Column
    private String allergyType;
    @Column
    private String allergyName;
    @Column
    private String allergyDescription;
    @Column
    private String allergyClinicalInformation;
//	private boolean fatal;

}

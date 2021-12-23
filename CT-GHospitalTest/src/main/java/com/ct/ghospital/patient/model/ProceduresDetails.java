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
@Table(name = "proceduresdetails")
public class ProceduresDetails {

    @Id
    @Column(name = "proceduresId")
    private String proceduresId;
    @Column
    private String proceduresCode;
    @Column
    private String proceduresName;
    @Column
    private String proceduresIdDescription;

}

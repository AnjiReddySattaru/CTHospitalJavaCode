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
@Table(name = "vitalsigns")
public class VitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "visitDetailsId")
    private Integer visitDetailsId;
    @Column
    private Integer height;
    @Column
    private Integer weight;
    @Column
    private Integer bloodPressure;
    @Column
    private Integer bodyTemperature;
    @Column
    private Integer respirationRate;
    @Column
    private Date visitDate;
}

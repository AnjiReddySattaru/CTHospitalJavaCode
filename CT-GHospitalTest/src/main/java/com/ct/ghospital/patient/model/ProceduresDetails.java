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
    private Integer proceduresId;
    @Column
    private String proceduresCode;
    @Column
    private String proceduresName;
    @Column
    private String proceduresIdDescription;
	public Integer getProceduresId() {
		return proceduresId;
	}
	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}
	public String getProceduresCode() {
		return proceduresCode;
	}
	public void setProceduresCode(String proceduresCode) {
		this.proceduresCode = proceduresCode;
	}
	public String getProceduresName() {
		return proceduresName;
	}
	public void setProceduresName(String proceduresName) {
		this.proceduresName = proceduresName;
	}
	public String getProceduresIdDescription() {
		return proceduresIdDescription;
	}
	public void setProceduresIdDescription(String proceduresIdDescription) {
		this.proceduresIdDescription = proceduresIdDescription;
	}

}

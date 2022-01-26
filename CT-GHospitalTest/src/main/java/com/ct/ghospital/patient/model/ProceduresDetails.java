package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "proceduresdetails")
public class ProceduresDetails {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proceduresid")
	@NotEmpty(message = "This field cannot be empty")
	private Integer proceduresId;
	@Column(name = "procedures_code")
	@NotEmpty(message = "This field cannot be empty")
	private String proceduresCode;
	@Column(name = "procedures_name")
	@NotEmpty(message = "This field cannot be empty")
	private String proceduresName;
	@Column(name = "procedure_is_depricated")
	@NotEmpty(message = "This field cannot be empty")
	private Boolean procedureIsDepricated;
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
	public Boolean getProcedureIsDepricated() {
		return procedureIsDepricated;
	}
	public void setProcedureIsDepricated(Boolean procedureIsDepricated) {
		this.procedureIsDepricated = procedureIsDepricated;
	}

}

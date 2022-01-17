package com.ct.ghospital.patient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="city_list")
public class CityList {
	@Id	
	@Column(name="city_code")
	private String city_code;
	
	@Column(name="city_name", nullable = false, length = 30)
	private String city_name;
	
	@Column(name="state_code", nullable = false, length = 30)
	private Integer state_code;


	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Integer getState_code() {
		return state_code;
	}

	public void setState_code(Integer state_code) {
		this.state_code = state_code;
	}


	
}

package com.ct.ghospital.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.model.CityList;
import com.ct.ghospital.patient.model.StateList;

public interface StatelistRepo extends JpaRepository<StateList, Integer>{
	

}

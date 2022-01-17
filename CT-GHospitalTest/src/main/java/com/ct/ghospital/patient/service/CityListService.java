package com.ct.ghospital.patient.service;

import java.util.List;

import com.ct.ghospital.patient.model.CityList;

public interface CityListService {

	List<CityList> getallCitylist(int state_code);
}

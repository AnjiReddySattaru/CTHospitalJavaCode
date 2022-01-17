package com.ct.ghospital.patient.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.ghospital.patient.model.CityList;
import com.ct.ghospital.patient.repo.CityListRepo;
import com.ct.ghospital.patient.service.CityListService;

@Service
public class CityServiceImpl implements CityListService{

	@Autowired
	CityListRepo cityrepo;

	@Override
	public List<CityList> getallCitylist(int state_code) {
		// TODO Auto-generated method stub
		return cityrepo.getCityList(state_code);
	}

	

	
	
}

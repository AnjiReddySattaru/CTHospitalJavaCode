package com.ct.ghospital.patient.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.ghospital.patient.model.CityList;
import com.ct.ghospital.patient.model.StateList;
import com.ct.ghospital.patient.repo.StatelistRepo;
import com.ct.ghospital.patient.service.statelistService;

@Service
public class StateserviceImpl implements statelistService {

	@Autowired
	StatelistRepo staterepo;
	
	@Override
	public List<StateList> getAllStatelist() {
		// TODO Auto-generated method stub
		return new ArrayList<StateList> (staterepo.findAll());
	}

	

}

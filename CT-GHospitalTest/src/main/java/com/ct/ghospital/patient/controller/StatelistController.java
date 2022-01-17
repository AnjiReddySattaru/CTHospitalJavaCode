package com.ct.ghospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ct.ghospital.patient.model.CityList;
import com.ct.ghospital.patient.model.StateList;
import com.ct.ghospital.patient.service.statelistService;

@RestController
@CrossOrigin
public class StatelistController {
	@Autowired
	
	statelistService statelistservice;
	
	@GetMapping("/statelist")
    public List<StateList> getAllAddressDetails() {
        return statelistservice.getAllStatelist();
    }
	
//	@GetMapping("/citylist/{stateid}")
//	public List<CityList> getallCityList(@PathVariable("stateid") String stateid){
//		return statelistservice.getallCitylist(stateid);
//	}
	

}

package com.ct.ghospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ct.ghospital.patient.model.CityList;
import com.ct.ghospital.patient.service.CityListService;

@RestController
public class CityListController {

	@Autowired
	CityListService cityservice;
	
	@GetMapping("/citylist/{state_code}")
	public List<CityList> getallCityList(@PathVariable("state_code") int state_code){
		return cityservice.getallCitylist(state_code);
	}
}

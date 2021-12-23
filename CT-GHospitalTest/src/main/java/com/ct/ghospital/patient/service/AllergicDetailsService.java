package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.AllergicDetails;

import java.util.List;

public interface AllergicDetailsService {
    List<AllergicDetails> getAllAllergicDetails();

    AllergicDetails getAllergicDetails(Integer id) throws Exception;

    AllergicDetails saveAllergicDetails(AllergicDetails allergicDetails);

    AllergicDetails updateAllergicDetails(Integer id, AllergicDetails allergicDetails) throws Exception;

    void deleteAllergicDetails(Integer id) throws Exception;
}

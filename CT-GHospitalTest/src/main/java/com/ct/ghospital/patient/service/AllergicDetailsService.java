package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.exception.AllergyDetailsException;
import com.ct.ghospital.patient.model.AllergicDetails;

import java.util.List;

public interface AllergicDetailsService {
    List<AllergicDetails> getAllAllergicDetails();

    AllergicDetails getAllergicDetails(Integer id) throws AllergyDetailsException;

    AllergicDetails saveAllergicDetails(AllergicDetails allergicDetails);

    AllergicDetails updateAllergicDetails(Integer id, AllergicDetails allergicDetails) throws AllergyDetailsException;

    void deleteAllergicDetails(Integer id) throws AllergyDetailsException;
}

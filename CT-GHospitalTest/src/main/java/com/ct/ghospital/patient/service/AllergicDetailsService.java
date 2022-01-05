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
    
    List<AllergicDetails> getAllergicDetailsByType(String string) throws AllergyDetailsException;
    
    List<AllergicDetails> getAllergicDetailsByName(String string) throws AllergyDetailsException;
    
    List<AllergicDetails> getAllergicDetailsDescription(String string) throws AllergyDetailsException;
    
    List<AllergicDetails> getAllergicDetailsClinicalInfo(String string) throws AllergyDetailsException;
    
    
}

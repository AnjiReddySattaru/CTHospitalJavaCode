package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.repo.AllergicDetailsRepo;
import com.ct.ghospital.patient.service.AllergicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AllergicDetailsServiceImpl implements AllergicDetailsService {

    @Autowired
    AllergicDetailsRepo allergicDetailsRepo;

    @Override
    public List<AllergicDetails> getAllAllergicDetails() {
        return new ArrayList<>(allergicDetailsRepo.findAll());
    }

    @Override
    public AllergicDetails getAllergicDetails(Integer id) throws Exception {
        Optional<AllergicDetails> allergicDetailsOptional = allergicDetailsRepo.findById(id);
        if (allergicDetailsOptional.isPresent()) {
            return allergicDetailsOptional.get();
        } else {
            throw new Exception("Allergic Details is not present");
        }
    }

    @Override
    public AllergicDetails saveAllergicDetails(AllergicDetails allergicDetails) {
        return allergicDetailsRepo.save(allergicDetails);
    }

    @Override
    public AllergicDetails updateAllergicDetails(Integer id, AllergicDetails allergicDetails) throws Exception {
        AllergicDetails pAllergicDetails = getAllergicDetails(id);
        pAllergicDetails.setAllergyType(allergicDetails.getAllergyType());
        pAllergicDetails.setAllergyName(allergicDetails.getAllergyName());
        pAllergicDetails.setAllergyDescription(allergicDetails.getAllergyDescription());
        pAllergicDetails.setAllergyClinicalInformation(allergicDetails.getAllergyClinicalInformation());
        allergicDetailsRepo.save(pAllergicDetails);
        return pAllergicDetails;
    }

    @Override
    public void deleteAllergicDetails(Integer id) throws Exception {
        AllergicDetails allergicDetails = getAllergicDetails(id);
        allergicDetailsRepo.delete(allergicDetails);
    }
}

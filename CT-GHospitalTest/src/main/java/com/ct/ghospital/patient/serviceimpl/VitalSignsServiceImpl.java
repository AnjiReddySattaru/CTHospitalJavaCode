package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.model.VitalSigns;
import com.ct.ghospital.patient.repo.VitalSignsRepo;
import com.ct.ghospital.patient.service.VitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VitalSignsServiceImpl implements VitalSignsService {

    @Autowired
    private VitalSignsRepo vitalSignsRepo;

    @Override
    public List<VitalSigns> getAllVitalSignsDetails() {
        return new ArrayList<>(vitalSignsRepo.findAll());
    }

    @Override
    public VitalSigns getVitalSignsDetails(Integer vitalsignsid) throws Exception {
        Optional<VitalSigns> vitalSignsOptional = vitalSignsRepo.findById(vitalsignsid);
        if (vitalSignsOptional.isPresent()) {
            return vitalSignsOptional.get();
        } else {
            throw new Exception("Vital Signs is not present");
        }
    }

    @Override
    public VitalSigns saveVitalSignsDetails(VitalSigns vitalSigns) {
        return vitalSignsRepo.save(vitalSigns);
    }

    @Override
    public VitalSigns updateVitalSignsDetails(Integer vitalsignsid, VitalSigns vitalSigns) throws Exception {
        VitalSigns pvitalSigns = getVitalSignsDetails(vitalsignsid);
        pvitalSigns.setHeight(vitalSigns.getHeight());
        pvitalSigns.setWeight(vitalSigns.getWeight());
        pvitalSigns.setBloodPressure(vitalSigns.getBloodPressure());
        pvitalSigns.setBodyTemperature(vitalSigns.getBodyTemperature());
        pvitalSigns.setVisitDate(vitalSigns.getVisitDate());
        pvitalSigns.setRespirationRate(vitalSigns.getRespirationRate());
        return vitalSignsRepo.save(vitalSigns);
    }

    @Override
    public void deleteVitalSigns(Integer vitalsignsid) throws Exception {
        VitalSigns vitalSigns = getVitalSignsDetails(vitalsignsid);
        vitalSignsRepo.delete(vitalSigns);
    }
}

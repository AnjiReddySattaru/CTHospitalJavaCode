package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.VitalSigns;

import java.util.List;

public interface VitalSignsService {
    List<VitalSigns> getAllVitalSignsDetails();

    VitalSigns getVitalSignsDetails(Integer id) throws Exception;

    VitalSigns saveVitalSignsDetails(VitalSigns vitalSigns);

    VitalSigns updateVitalSignsDetails(Integer id, VitalSigns vitalSigns) throws Exception;

    void deleteVitalSigns(Integer id) throws Exception;
}

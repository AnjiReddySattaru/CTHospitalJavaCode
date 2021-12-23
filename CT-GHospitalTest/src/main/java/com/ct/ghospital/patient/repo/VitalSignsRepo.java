package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.VitalSigns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalSignsRepo extends JpaRepository<VitalSigns, Integer> {
}

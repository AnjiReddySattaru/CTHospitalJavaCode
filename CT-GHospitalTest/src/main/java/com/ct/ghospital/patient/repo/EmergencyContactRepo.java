package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactRepo extends JpaRepository<EmergencyContact, Integer> {
}

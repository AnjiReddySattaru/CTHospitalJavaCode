package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.AllergicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergicDetailsRepo extends JpaRepository<AllergicDetails, Integer> {
}

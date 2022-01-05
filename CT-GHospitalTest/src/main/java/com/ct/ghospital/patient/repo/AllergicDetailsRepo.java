package com.ct.ghospital.patient.repo;

import com.ct.ghospital.patient.model.AllergicDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergicDetailsRepo extends JpaRepository<AllergicDetails, Integer> {
	@Query(value = "SELECT * FROM allergydetails t WHERE t.allergy_type LIKE %:allergytype% ", nativeQuery = true)
	List<AllergicDetails> getAllergicDetailsByType(@Param("allergytype") String allergytype);
	
	@Query(value = "SELECT * FROM allergydetails t WHERE t.allergy_name LIKE %:allergyname% ", nativeQuery = true)
	List<AllergicDetails> getAllergicDetailsByName(@Param("allergyname") String allergyname);
	
	@Query(value = "SELECT * FROM allergydetails t WHERE t.allergy_description LIKE %:allergydescription% ", nativeQuery = true)
	List<AllergicDetails> getAllergicDetailsByDescription(@Param("allergydescription") String allergydescription);
	
	@Query(value = "SELECT * FROM allergydetails t WHERE t.allergy_clinical_information LIKE %:allergyclinicalinfo% ", nativeQuery = true)
	List<AllergicDetails> getAllergicDetailsByClinicalInfo(@Param("allergyclinicalinfo") String allergyclinicalinfo);
	
}

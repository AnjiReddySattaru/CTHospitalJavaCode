package com.ct.ghospital.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ct.ghospital.patient.model.CityList;

public interface CityListRepo extends JpaRepository<CityList, Integer> {
	@Query(value ="SELECT * FROM city_list t WHERE t.state_code = :state_code",nativeQuery = true)
	List<CityList> getCityList(@Param("state_code") int state_code);
}

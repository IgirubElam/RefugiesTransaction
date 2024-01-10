package com.refugietransaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.Camp;

public interface CampRepository extends JpaRepository<Camp, Long> {
	
	// JPQL query
	  @Query(value = "select c from Camp c where c.nom_camp = :nom_camp")
	  Optional<Camp> findCampByName(@Param("nom_camp") String nom_camp);
}

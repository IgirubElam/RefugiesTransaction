package com.refugietransaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.Menage;

public interface MenageRepository extends JpaRepository<Menage, Long> {

	List<Menage> findAllById(Long id);
	// JPQL query
	@Query(value = "select m from Menage m where m.id_number = :id_number")
	Optional<Menage> findMenageByIdNumber(@Param("id_number") Long id_number);

}

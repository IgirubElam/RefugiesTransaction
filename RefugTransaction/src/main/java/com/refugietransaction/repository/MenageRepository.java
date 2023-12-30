package com.refugietransaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Menage;

public interface MenageRepository extends JpaRepository<Menage, Long> {

	List<Menage> findAllById(Long id);

}

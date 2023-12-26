package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Camp;

public interface CampRepository extends JpaRepository<Camp, Integer> {

	Camp findByName(String nom);

}

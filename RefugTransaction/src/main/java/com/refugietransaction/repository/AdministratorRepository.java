package com.refugietransaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	List<Administrator> findAllById(Long id);

	

}

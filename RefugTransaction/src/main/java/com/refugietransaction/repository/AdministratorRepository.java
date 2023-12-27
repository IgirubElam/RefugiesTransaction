package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}

package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}

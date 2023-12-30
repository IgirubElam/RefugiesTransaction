package com.refugietransaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

	List<org.aspectj.weaver.loadtime.Agent> findAllById(Long id);

}

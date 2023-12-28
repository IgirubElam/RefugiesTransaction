package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.AgentDto;

public interface AgentService {
	
	AgentDto save(AgentDto dto);
	
	AgentDto findById(Long id);
	
	List<AgentDto> findAll();
	
	void update(Long id);
	
	void delete(Long id);
}

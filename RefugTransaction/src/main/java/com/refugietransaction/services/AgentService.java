package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.AgentDto;

public interface AgentService {
	
	AgentDto save(AgentDto dto);
	
	AgentDto findById(Long id);
	
	List<AgentDto> findAll();
	
	List<AgentDto> findAllByUserId(Long id);
	
	void update(Long id, AgentDto updatedDto);
	
	void delete(Long id);
}

package com.refugietransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.refugietransaction.controller.api.AgentApi;
import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.services.AgentService;

@RestController

public class AgentController implements AgentApi {
	
	private AgentService agentService;
	
	@Autowired
	public AgentController(AgentService agentService) {
		this.agentService = agentService;
	}

	@Override
	public AgentDto save(AgentDto dto) {
		return agentService.save(dto);
	}

	@Override
	public AgentDto findById(Long idAgent) {
		return agentService.findById(idAgent);
	}

	@Override
	public List<AgentDto> findAll() {
		return agentService.findAll();
	}

	@Override
	public void delete(Long idAgent) {
		agentService.delete(idAgent);
		
	}

	@Override
	public void update(Long idAgent, AgentDto updatedDto) {
		agentService.update(idAgent, updatedDto);
		
	}

	@Override
	public List<AgentDto> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

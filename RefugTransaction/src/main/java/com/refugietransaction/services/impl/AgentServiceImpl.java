package com.refugietransaction.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.repository.AgentRepository;
import com.refugietransaction.repository.MouvementStockRepository;
import com.refugietransaction.services.AgentService;

public class AgentServiceImpl implements AgentService {
	
	private AgentRepository agentRepository;
	private MouvementStockRepository mouvementStockRepository;
	
	@Autowired
	public AgentServiceImpl(AgentRepository agentRepository, MouvementStockRepository mouvementStockRepository) {
		this.agentRepository = agentRepository;
		this.mouvementStockRepository = mouvementStockRepository;
	}
	
	@Override
	public AgentDto save(AgentDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgentDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgentDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

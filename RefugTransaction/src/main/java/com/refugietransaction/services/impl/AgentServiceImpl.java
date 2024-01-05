package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.exceptions.InvalidOperationException;
import com.refugietransaction.model.MouvementStock;
import com.refugietransaction.repository.AgentRepository;
import com.refugietransaction.repository.MouvementStockRepository;
import com.refugietransaction.services.AgentService;
import com.refugietransaction.validator.AgentValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		List<String> errors = AgentValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Article is not valid {}", dto);
	      throw new InvalidEntityException("L'agent n'est pas valide", ErrorCodes.AGENT_NOT_VALID, errors);
	    }
	    return AgentDto.fromEntity(
	        agentRepository.save(AgentDto.toEntity(dto))
	    );
	}

	@Override
	public AgentDto findById(Long id) {
		if (id == null) {
		      log.error("Agent ID is null");
		      return null;
		    }
		    return agentRepository.findById(id)
		        .map(AgentDto::fromEntity)
		        .orElseThrow(() -> new EntityNotFoundException(
		            "Aucun agent avec l'ID = " + id + " n' ete trouve dans la BDD",
		            ErrorCodes.AGENT_NOT_FOUND)
		        );
	}

	@Override
	public List<AgentDto> findAll() {
		return agentRepository.findAll().stream()
		        .map(AgentDto::fromEntity)
		        .collect(Collectors.toList());
	}

	@Override
	public void update(Long id, AgentDto updatedDto) {
		if (id == null) {
	        log.error("Agent ID is null");
	        return;
	    }

	    AgentDto existingAgentDto = findById(id);

	    if (existingAgentDto == null) {
	        throw new EntityNotFoundException("Agent not found with ID: " + id, ErrorCodes.AGENT_NOT_FOUND);
	    }

	    List<String> errors = AgentValidator.validate(updatedDto);
	    if (!errors.isEmpty()) {
	        log.error("Updated agent is not valid {}", updatedDto);
	        throw new InvalidEntityException("L'agent mis à jour n'est pas valide", ErrorCodes.AGENT_NOT_VALID, errors);
	    }

	    existingAgentDto.setCamp(updatedDto.getCamp());
	    

	    agentRepository.save(AgentDto.toEntity(existingAgentDto));
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
		      log.error("Agent ID is null");
		      return;
		    }
		    List<MouvementStock> mouvementStocks = mouvementStockRepository.findAllById(id);
		    if (!mouvementStocks.isEmpty()) {
		      throw new InvalidOperationException("Impossible de supprimer cet agent qui est deja utilise",
		          ErrorCodes.AGENT_ALREADY_EXISTS);
		    }
		    agentRepository.deleteById(id);
		  }

	@Override
	public List<AgentDto> findAllByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
		

}

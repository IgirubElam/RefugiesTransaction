package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.dto.CampDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.exceptions.InvalidOperationException;
import com.refugietransaction.model.Menage;
import com.refugietransaction.repository.AgentRepository;
import com.refugietransaction.repository.CampRepository;
import com.refugietransaction.repository.MenageRepository;
import com.refugietransaction.services.CampService;
import com.refugietransaction.validator.AgentValidator;
import com.refugietransaction.validator.CampValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CampServiceImpl implements CampService {
	
	private CampRepository campRepository;
	private MenageRepository menageRepository;
	private AgentRepository agentRepository;
	
	@Autowired
	public CampServiceImpl(CampRepository campRepository, MenageRepository menageRepository, AgentRepository agentRepository) {
		this.campRepository = campRepository;
		this.menageRepository = menageRepository;
		this.agentRepository = agentRepository;
	}
	
	@Override
	public CampDto save(CampDto dto) {
		// TODO Auto-generated method stub
		List<String> errors = CampValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Menage is not valid {}", dto);
			log.error("Agent is not valid {}", dto);
			throw new InvalidEntityException("Le camp n'est pas valide", ErrorCodes.CAMP_NOT_VALID, errors);
		}
		return CampDto.fromEntity(
				campRepository.save(CampDto.toEntity(dto))
		);
	}

	@Override
	public void update(Long id, CampDto updatedDto) {
		if (id == null) {
	        log.error("Camp ID is null");
	        return;
	    }

	    CampDto existingCampDto = findById(id);

	    if (existingCampDto == null) {
	        throw new EntityNotFoundException("Camp not found with ID: " + id, ErrorCodes.CAMP_NOT_FOUND);
	    }

	    List<String> errors = CampValidator.validate(updatedDto);
	    if (!errors.isEmpty()) {
	        log.error("Updated camp is not valid {}", updatedDto);
	        throw new InvalidEntityException("Le camp mis à jour n'est pas valide", ErrorCodes.CAMP_NOT_VALID, errors);
	    }

	    existingCampDto.setNomCamp(updatedDto.getNomCamp());
	    

	    campRepository.save(CampDto.toEntity(existingCampDto));
		
	}

	@Override
	public CampDto findById(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			log.error("Camp ID is null");
			return null;
		}
		return campRepository.findById(id)
				.map(CampDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Aucun camp avec l'ID = " + id + " n'a ete trouvé dans la BDD",
						ErrorCodes.CAMP_NOT_FOUND)
						);
	}

	@Override
	public List<CampDto> findAll() {
		
		return campRepository.findAll().stream()
		        .map(CampDto::fromEntity)
		        .collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		if(id == null) {
			log.error("Camp ID is null");
			return;
		}
		List<Menage> menages = menageRepository.findAllById(id);
		List<Agent> agents = agentRepository.findAllById(id);
		if(!menages.isEmpty() || !agents.isEmpty()) {
			throw new InvalidOperationException("Impossible de supprimer ce camp qui est deja utilise",
					ErrorCodes.CAMP_ALREADY_IN_USE);
		}
		
	}
	
	
}

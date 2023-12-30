package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.UserDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.exceptions.InvalidOperationException;
import com.refugietransaction.model.Administrator;
import com.refugietransaction.repository.AdministratorRepository;
import com.refugietransaction.repository.AgentRepository;
import com.refugietransaction.repository.UserRepository;
import com.refugietransaction.services.UserService;
import com.refugietransaction.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private AdministratorRepository administratorRepository;
	private AgentRepository agentRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, AdministratorRepository administratorRepository, AgentRepository agentRepository) {
		this.userRepository = userRepository;
		this.administratorRepository = administratorRepository;
		this.agentRepository = agentRepository;
	}
	
	@Override
	public UserDto save(UserDto dto) {
		
		List<String> errors = UserValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Administrator is not valid {}", dto);
	      log.error("Agent is not valid {}", dto);
	      throw new InvalidEntityException("Le user n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
	    }
		return UserDto.fromEntity(
				userRepository.save(UserDto.toEntity(dto))
		);
	}

	@Override
	public UserDto findById(Long id) {
		
		if (id == null) {
		      log.error("User ID is null");
		      return null;
		    }
		return userRepository.findById(id)
				.map(UserDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Aucun utilisateur avec l'ID = " +id+ " n' a ete trouve dans la BDD",
						ErrorCodes.UTILISATEUR_NOT_FOUND)
						);
	}

	@Override
	public List<UserDto> findAll() {
		
		return userRepository.findAll().stream()
				.map(UserDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		if(id == null) {
			log.error("User ID is null");
			return;
		}
		List<Administrator> administrators = administratorRepository.findAllById(id);
		List<Agent> agents = agentRepository.findAllById(id);
		if(!administrators.isEmpty() || !agents.isEmpty()) {
			throw new InvalidOperationException("Impossible de supprimer cet utilisateur qui est deja utilisé",
					ErrorCodes.UTILISATEUR_ALREADY_EXISTS);
		}
		
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

}

package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.AdministratorDto;
import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.dto.ChangerUserPasswordDto;
import com.refugietransaction.dto.UserDto;

public interface UserService {
	
	UserDto save(UserDto userDto, AdministratorDto administratorDto, AgentDto agentDto);
	
	UserDto findById(Long id);
	
	List<UserDto> findAll();
	
	void delete(Long id);

	UserDto findByEmail(String email);

	UserDto changerMotDePasse(ChangerUserPasswordDto dto);
}

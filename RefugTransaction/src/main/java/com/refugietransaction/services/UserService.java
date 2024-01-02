package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.UserDto;

public interface UserService {
	
	UserDto save(UserDto dto);
	
	UserDto findById(Long id);
	
	List<UserDto> findAll();
	
	void delete(Long id);
	
	void update(Long id, UserDto updatedDto);
}

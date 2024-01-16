package com.refugietransaction.services;

import java.util.List;
import com.refugietransaction.dto.ChangerUserPasswordDto;
import com.refugietransaction.dto.UserDto;

public interface UserService {
	
	UserDto save(UserDto dto);
	
	UserDto findById(Long id);
	
	List<UserDto> findAll();
	
	void delete(Long id);

	UserDto findByEmail(String email);

	UserDto changerMotDePasse(ChangerUserPasswordDto dto);
}

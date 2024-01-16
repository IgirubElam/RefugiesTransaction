package com.refugietransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.refugietransaction.controller.api.UserApi;
import com.refugietransaction.dto.UserDto;
import com.refugietransaction.services.UserService;

@RestController
public class UserController implements UserApi {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDto save(UserDto dto) {
		return userService.save(dto);
	}

	@Override
	public UserDto findById(Long idUser) {
		return userService.findById(idUser);
	}

	@Override
	public UserDto findByEmail(String email) {
		return userService.findByEmail(email);
	}

	@Override
	public List<UserDto> findAll() {
		return userService.findAll();
	}

	@Override
	public void delete(Long id) {
		userService.delete(id);
	}

}

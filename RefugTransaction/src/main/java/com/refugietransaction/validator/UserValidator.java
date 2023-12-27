package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.UserDto;

public class UserValidator {
	public static List<String> validate(UserDto userDto){
		List<String> errors = new ArrayList<>();
		
		if(userDto == null || !StringUtils.hasLength(userDto.getUserName())) {
			errors.add("Veuillez renseigner le username");
		}
		if(userDto == null || !StringUtils.hasLength(userDto.getPhoneNumber())) {
			errors.add("Veuillez renseigner le numero de telephone");
		}
		if(userDto == null || !StringUtils.hasLength(userDto.getEmail())) {
			errors.add("Veuillez renseigner l'email");
		}
		if(userDto == null || !StringUtils.hasLength(userDto.getPassword())) {
			errors.add("Veuillez renseigner le password");
		}
		if(userDto.getTypeUser() == null) {
			errors.add("Veuillez renseigner le username");
		}
		return errors;
	}
}

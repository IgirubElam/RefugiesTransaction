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
		return errors;
	}
}

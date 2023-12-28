package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.UserDto;

public class UserValidator {
	public static List<String> validate(UserDto userDto){
		List<String> errors = new ArrayList<>();
		
		if(userDto == null) {
			errors.add("Veuillez renseigner le username");
			errors.add("Veuillez renseigner le numero de telephone");
			errors.add("Veuillez renseigner l'email");
			errors.add("Veuillez renseigner le password");
		}
		if(userDto.getTypeUser() == null) {
			errors.add("Veuillez selectionner le type user");
		}
		return errors;
	}
}

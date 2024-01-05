package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.UserDto;

public class UserValidator {
	public static List<String> validate(UserDto userDto){
		List<String> errors = new ArrayList<>();
		
		if(userDto == null) {
			errors.add("Veuillez renseigner le nom complet de l'utilisateur");
			errors.add("Veuillez renseigner le numero de telephone de l'utilisateur");
			errors.add("Veuillez renseigner l'email de l'utilisateur");
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
		}
		
		if(!StringUtils.hasLength(userDto.getUserName())) {
			errors.add("Veuillez renseigner le nom complet de l'utilisateur");
		}

		if(!StringUtils.hasLength(userDto.getPhoneNumber())) {
			errors.add("Veuillez renseigner le numero de telephone de l'utilisateur");
		}

		if(!StringUtils.hasLength(userDto.getEmail())) {
			errors.add("Veuillez renseigner l'email de l'utilisateur");
		}

		if(!StringUtils.hasLength(userDto.getPassword())) {
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
		}

		if (userDto.getTypeUser().name().equals("AGENT") && userDto.getAgents().isEmpty()){

			errors.add("Veuillez renseigner le camp d'affectaction ");
		}
		
		return errors;
	}
}

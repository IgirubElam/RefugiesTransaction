package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.UserDto;
import com.refugietransaction.model.TypeUser;

public class UserValidator {
	public static List<String> validate(UserDto userDto){
		List<String> errors = new ArrayList<>();
		
		if(userDto == null) {
			errors.add("Veuillez renseigner le nom complet de l'utilisateur");
			errors.add("Veuillez renseigner le numero de telephone de l'utilisateur");
			errors.add("Veuillez renseigner l'email de l'utilisateur");
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
			errors.addAll(UserAssignmentValidator.validate(null));
			return errors;
		}
		
		if(!StringUtils.hasLength(userDto.getUserFullName())) {
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
		
		if(userDto.getTypeUser() == TypeUser.AGENT) {
			errors.addAll(UserAssignmentValidator.validate(userDto.getUserAssignment()));
		}
		
		return errors;
	}
}

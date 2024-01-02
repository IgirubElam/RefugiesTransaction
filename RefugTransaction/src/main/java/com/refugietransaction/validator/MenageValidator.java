package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.MenageDto;

public class MenageValidator {
	public static List<String> validate(MenageDto menageDto){
		List<String> errors = new ArrayList<>();
		
		if (menageDto == null) {
		    errors.add("Veuillez renseigner la personne de contact");
		    errors.add("Veuillez renseigner le numero de telephone");
		    return errors;
		}
		
		if(menageDto.getLangueParlee() == null) {
			errors.add("Veillez choisir la langue parlee");
		}
		
		return errors;
	}
}

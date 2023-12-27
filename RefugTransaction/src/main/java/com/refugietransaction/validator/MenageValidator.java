package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.MenageDto;

public class MenageValidator {
	public static List<String> validate(MenageDto menageDto){
		List<String> errors = new ArrayList<>();
		
		if(menageDto == null || !StringUtils.hasLength(menageDto.getNumTelephone())) {
			errors.add("Veuillez reseigner le numero du menage");
		}
		
		if(menageDto == null || !StringUtils.hasLength(menageDto.getPersonneContact())) {
			errors.add("Veillez renseigner la personne de contact");
		}
		
		if(menageDto.getIdNumber() == null) {
			errors.add("Veillez renseigner le numero");
		}
		
		if(menageDto.getLangueParlee() == null) {
			errors.add("Veillez choisir la langue parlee");
		}
		
		return errors;
	}
}

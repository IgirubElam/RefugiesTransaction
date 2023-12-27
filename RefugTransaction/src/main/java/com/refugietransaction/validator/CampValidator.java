package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import com.refugietransaction.dto.CampDto;

import io.micrometer.common.util.StringUtils;

public class CampValidator {
	
	public static List<String> validate(CampDto campDto){
		List<String> errors = new ArrayList<>();
		
		if(campDto == null || ! StringUtils.hasLength(campDto.getNomCamp())) {
			errors.add("Veuillez renseigner le nom du camp");
		}
		return errors;
	}
}

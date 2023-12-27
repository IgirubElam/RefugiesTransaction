package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.refugietransaction.dto.MouvementStockDto;

public class MouvementStockValidator {
	public static List<String> validate(MouvementStockDto mouvementStockDto){
		List<String> errors = new ArrayList<>();
		
		if(mouvementStockDto == null || !StringUtils.hasLength(mouvementStockDto.getDateMouvement().toString())) {
			errors.add("Veillez renseigner la quantite");
		}
		if(mouvementStockDto == null || !StringUtils.hasLength(mouvementStockDto.getQuantite().toString())) {
			errors.add("Veillez renseigner la quantite");
		}
		
		return errors;
	}
}

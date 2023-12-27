package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;
import com.refugietransaction.dto.MouvementStockDto;

public class MouvementStockValidator {
	public static List<String> validate(MouvementStockDto mouvementStockDto){
		List<String> errors = new ArrayList<>();
		
		if(mouvementStockDto.getDateMouvement() == null) {
			errors.add("Veillez renseigner la date mouvement");
		}
		if(mouvementStockDto.getQuantite() == null) {
			errors.add("Veillez renseigner la quantite");
		}
		
		return errors;
	}
}

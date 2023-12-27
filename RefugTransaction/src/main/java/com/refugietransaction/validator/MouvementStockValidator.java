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
		if(mouvementStockDto.getTypeMouvement() == null) {
			errors.add("Veillez choir le type mouvement");
		}
		if(mouvementStockDto.getIdArticle() == null) {
			errors.add("Veillez choisir le produit");
		}
		if(mouvementStockDto.getMenage() == null) {
			errors.add("Veillez choisir le menage");
		}
		return errors;
	}
}

package com.refugietransaction.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.refugietransaction.dto.MouvementStockDto;

public class MouvementStockValidator {
	public static List<String> validate(MouvementStockDto mouvementStockDto){
		List<String> errors = new ArrayList<>();
		
		if(mouvementStockDto.getDateMouvement() == null) {
			errors.add("Veillez renseigner la date mouvement");
		}
		if(mouvementStockDto.getQuantite() == null || mouvementStockDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
			errors.add("Veillez renseigner la quantite");
		}
		if(mouvementStockDto.getTypeMouvement() == null) {
			errors.add("Veillez selectionner le type mouvement");
		}
		if(mouvementStockDto.getIdArticle() == null || mouvementStockDto.getIdArticle().getId() == null) {
			errors.add("Veillez selectionner le produit");
		}
		if(mouvementStockDto.getMenage() == null || mouvementStockDto.getMenage().getId() == null) {
			errors.add("Veillez selectionner une menage");
		}
		return errors;
	}
}

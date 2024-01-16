package com.refugietransaction.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import com.refugietransaction.model.Menage;
import com.refugietransaction.model.MouvementStock;
import com.refugietransaction.model.Produit;
import com.refugietransaction.model.TypeMouvementStock;
import com.refugietransaction.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MouvementStockDto {
	
	private Long id;
	private Date dateMouvement;
	private BigDecimal quantite;
	private TypeMouvementStock typeMouvement;
	private Menage menage;
	private Produit produit;
	private User user;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	public static MouvementStockDto fromEntity(MouvementStock mouvementStock) {
		if(mouvementStock == null) {
			return null;
			//TODO throw an exception
		}
		
		return MouvementStockDto.builder()
				.id(mouvementStock.getId())
				.dateMouvement(mouvementStock.getDateMouvement())
				.quantite(mouvementStock.getQuantite())
				.typeMouvement(mouvementStock.getTypeMouvement())
				.menage(mouvementStock.getMenage())
				.produit(mouvementStock.getProduit())
				.user(mouvementStock.getUser())
				.creationDate(mouvementStock.getCreationDate())
				.lastModifiedDate(mouvementStock.getLastModifiedDate())
				.build();
	}
	
	public static MouvementStock toEntity(MouvementStockDto mouvementStockDto) {
		if(mouvementStockDto == null) {
			return null;
			//TODO throw an exception
		}
		
		MouvementStock mouvementStock = new MouvementStock();
		mouvementStock.setId(mouvementStockDto.getId());
		mouvementStock.setDateMouvement(mouvementStockDto.getDateMouvement());
		mouvementStock.setQuantite(mouvementStockDto.getQuantite());
		mouvementStock.setTypeMouvement(mouvementStockDto.getTypeMouvement());
		mouvementStock.setMenage(mouvementStockDto.getMenage());
		mouvementStock.setProduit(mouvementStockDto.getProduit());
		mouvementStock.setUser(mouvementStockDto.getUser());
		mouvementStock.setCreationDate(mouvementStockDto.getCreationDate());
		mouvementStock.setLastModifiedDate(mouvementStockDto.getLastModifiedDate());
		
		return mouvementStock;
	}
}

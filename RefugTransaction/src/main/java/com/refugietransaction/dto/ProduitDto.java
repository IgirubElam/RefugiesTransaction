package com.refugietransaction.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.refugietransaction.model.Produit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitDto {
	
	private Long id;
	private String nomProduit;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	@JsonIgnore List<MouvementStockDto> mouvementStocks;
	
	public static ProduitDto fromEntity(Produit produit) {
		if(produit == null) {
			return null;
			//TODO throw an exception
		}
		
		return ProduitDto.builder()
				.id(produit.getId())
				.nomProduit(produit.getNomProduit())
				.creationDate(produit.getCreationDate())
				.lastModifiedDate(produit.getLastModifiedDate())
				.build();
	}
	
	public static Produit toEntity(ProduitDto produitDto) {
		if(produitDto == null) {
			return null;
			//TODO throw an exception
		}
		
		Produit produit = new Produit();
		produit.setId(produitDto.getId());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setCreationDate(produitDto.getCreationDate());
		produit.setLastModifiedDate(produitDto.getLastModifiedDate());
		
		return produit;
		
	}
}

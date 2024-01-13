package com.refugietransaction.services;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.model.TypeMouvementStock;

public interface MouvementStockService {
	
	BigDecimal stockReelMenage(Long idProduit, Long idMenage);

	List<MouvementStockDto> mvtStkArticleMenage(Long idProduit, Long idMenage);

	MouvementStockDto entreeStock(MouvementStockDto dto);

	MouvementStockDto sortieStock(MouvementStockDto dto); 
	
	List<MouvementStockDto> entreeArticleCamp(Long idProduit, Long idAgent);
	
	List<MouvementStockDto> sortieArticleCamp(Long idProduit, Long idAgent);
	
	List<MouvementStockDto> entreeArticleCampPeriode(Long idProduit, Long idAgent, Instant creationDate, Instant lastModifiedDate);
}

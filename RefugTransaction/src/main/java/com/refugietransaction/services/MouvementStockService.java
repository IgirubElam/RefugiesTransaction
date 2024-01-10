package com.refugietransaction.services;

import java.math.BigDecimal;
import java.util.List;

import com.refugietransaction.dto.MouvementStockDto;

public interface MouvementStockService {
	
	BigDecimal stockReelMenage(Long idProduit, Long idMenage);

	List<MouvementStockDto> mvtStkArticleMenage(Long idProduit, Long idMenage);

	MouvementStockDto entreeStock(MouvementStockDto dto);

	MouvementStockDto sortieStock(MouvementStockDto dto); 
}

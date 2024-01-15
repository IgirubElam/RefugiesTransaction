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
	
	//Pour le camp
	
	List<MouvementStockDto> entreeArticleCamp(Long idProduit, Long idCamp);
	
	List<MouvementStockDto> sortieArticleCamp(Long idProduit, Long idCamp);
	
	List<MouvementStockDto> entreeArticleCampPeriode(Long idProduit, Long idCamp, Instant startDate, Instant endDate);
	
	List<MouvementStockDto> sortieArticleCampPeriode(Long idProduit, Long idCamp, Instant startDate, Instant endDate);
	
	//Pour le menage
	
	List<MouvementStockDto> entreeArticleMenage(Long idProduit, Long idMenage);
	
	List<MouvementStockDto> sortieArticleMenage(Long idProduit, Long idMenage);
	
	List<MouvementStockDto> entreeArticleMenagePeriode(Long idProduit, Long idMenage, Instant startDate, Instant endDate);
	
	List<MouvementStockDto> sortieArticleMenagePeriode(Long idProduit, Long idMenage, Instant startDate, Instant endDate);
	
	//Pour l'agent
	
	List<MouvementStockDto> entreeArticleAgent(Long idProduit, Long idAgent);
	
	List<MouvementStockDto> sortieArticleAgent(Long idProduit, Long idAgent);
	
	List<MouvementStockDto> entreeArticleAgentPeriode(Long idProduit, Long idAgent, Instant startDate, Instant endDate);
	
	List<MouvementStockDto> sortieArticleAgentPeriode(Long idProduit, Long idAgent, Instant startDate, Instant endDate);
	
	
	
}

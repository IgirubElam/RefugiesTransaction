package com.refugietransaction.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.refugietransaction.controller.api.MouvementStockApi;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.model.TypeMouvementStock;
import com.refugietransaction.services.MouvementStockService;

@RestController

public class MouvementStockController implements MouvementStockApi {
	
	private MouvementStockService mouvementStockService;
	
	@Autowired
	public MouvementStockController(MouvementStockService mouvementStockService) {
		this.mouvementStockService = mouvementStockService;
	}

	@Override
	public BigDecimal stockReelMenage(Long idProduit, Long idMenage) {
		return mouvementStockService.stockReelMenage(idProduit, idMenage);
	}

	@Override
	public List<MouvementStockDto> mvtStkArticleMenage(Long idProduit, Long idMenage) {
		return mouvementStockService.mvtStkArticleMenage(idProduit, idMenage);
	}

	@Override
	public MouvementStockDto entreeStock(MouvementStockDto dto) {
		return mouvementStockService.entreeStock(dto);
	}

	@Override
	public MouvementStockDto sortieStock(MouvementStockDto dto) {
		return mouvementStockService.sortieStock(dto);
	}

	@Override
	public List<MouvementStockDto> entreeArticleCamp(Long idProduit, Long idAgent) {
		return mouvementStockService.entreeArticleCamp(idProduit, idAgent);
	}

	@Override
	public List<MouvementStockDto> sortieArticleCamp(Long idProduit, Long idAgent) {
		return mouvementStockService.sortieArticleCamp(idProduit, idAgent);
	}

	@Override
	public List<MouvementStockDto> entreeArticleCampPeriode(Long idProduit, Long idAgent, Instant creationDate,
			Instant lastModifiedDate) {
		
		return mouvementStockService.entreeArticleCampPeriode(idProduit, idAgent, creationDate, lastModifiedDate);
	}

}

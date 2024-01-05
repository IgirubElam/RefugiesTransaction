package com.refugietransaction.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.refugietransaction.controller.api.MouvementStockApi;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.services.MouvementStockService;

public class MouvementStockController implements MouvementStockApi {
	
	private MouvementStockService mouvementStockService;
	
	@Autowired
	public MouvementStockController(MouvementStockService mouvementStockService) {
		this.mouvementStockService = mouvementStockService;
	}

	@Override
	public MouvementStockDto save(MouvementStockDto dto) {
		return mouvementStockService.save(dto);
	}

	@Override
	public MouvementStockDto findById(Long idMvtStock) {
		return mouvementStockService.findById(idMvtStock);
	}

	@Override
	public List<MouvementStockDto> findAll() {
		return mouvementStockService.findAll();
	}

	@Override
	public void delete(Long idMvtStock) {
		mouvementStockService.delete(idMvtStock);
		
	}

	@Override
	public void update(Long idMvtStock, MouvementStockDto updatedDto) {
		mouvementStockService.update(idMvtStock, updatedDto);
		
	}

	@Override
	public BigDecimal stockReelMenage(Long idProduit, Long idMenage) {
		return mouvementStockService.stockReelMenage(idProduit, idMenage);
	}

}

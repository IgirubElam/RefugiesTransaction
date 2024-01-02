package com.refugietransaction.services;

import java.math.BigDecimal;
import java.util.List;

import com.refugietransaction.dto.MouvementStockDto;

public interface MouvementStockService {
	
	MouvementStockDto save(MouvementStockDto dto);
	
	MouvementStockDto findById(Long id);
	
	List<MouvementStockDto> findAll();
	
	void delete(Long id);
	
	void update(Long id, MouvementStockDto updatedDto);
	
	BigDecimal stockReelMenage(Long idProduit, Long idMenage);
}

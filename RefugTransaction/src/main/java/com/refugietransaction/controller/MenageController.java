package com.refugietransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.refugietransaction.controller.api.MenageApi;
import com.refugietransaction.dto.MenageDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.services.MenageService;

public class MenageController implements MenageApi {
	
	private MenageService menageService;
	
	@Autowired
	public MenageController(MenageService menageService) {
		this.menageService = menageService;
	}

	@Override
	public MenageDto save(MenageDto dto) {
		return menageService.save(dto);
	}

	@Override
	public MenageDto findById(Long idMenage) {
		return menageService.findById(idMenage);
	}

	@Override
	public List<MenageDto> findAll() {
		return menageService.findAll();
	}

	@Override
	public List<MouvementStockDto> findHistoriqueMouvementStock(Long idProduit, Long idMenage) {
		return menageService.findHistoriqueMouvementStock(idProduit, idMenage);
	}

}

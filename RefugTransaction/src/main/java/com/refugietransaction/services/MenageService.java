package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.MenageDto;

public interface MenageService {
	
	MenageDto save(MenageDto dto);
	
	void update(Long id);
	
	MenageDto findById(Long id);
	
	List<MenageDto> findAll();
}

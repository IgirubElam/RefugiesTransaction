package com.refugietransaction.services;

import java.util.List;

import com.refugietransaction.dto.AdministratorDto;

public interface AdministratorService {
	
	AdministratorDto save(AdministratorDto dto);
	
	AdministratorDto findById(Long id);
	
	List<AdministratorDto> findAll();
	
	void update(Long id);
	
	void delete(Long id);
}

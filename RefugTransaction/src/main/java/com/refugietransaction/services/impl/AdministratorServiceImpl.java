package com.refugietransaction.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.AdministratorDto;
import com.refugietransaction.repository.AdministratorRepository;
import com.refugietransaction.services.AdministratorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AdministratorServiceImpl implements AdministratorService {
	
	private AdministratorRepository administratorRepository;
	
	@Autowired
	public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
		this.administratorRepository = administratorRepository;
	}
	
	@Override
	public AdministratorDto save(AdministratorDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministratorDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministratorDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdministratorDto> findAllByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

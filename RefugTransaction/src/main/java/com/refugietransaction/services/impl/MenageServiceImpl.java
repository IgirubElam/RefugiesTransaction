package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.MenageDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.repository.MenageRepository;
import com.refugietransaction.repository.MouvementStockRepository;
import com.refugietransaction.services.MenageService;
import com.refugietransaction.validator.MenageValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenageServiceImpl implements MenageService {
	
	private MenageRepository menageRepository;
	private MouvementStockRepository mouvementStockRepository;
	
	@Autowired
	public MenageServiceImpl(MenageRepository menageRepository, MouvementStockRepository mouvementStockRepository) {
		this.menageRepository = menageRepository;
		this.mouvementStockRepository = mouvementStockRepository;
	}
	
	
	@Override
	public MenageDto save(MenageDto dto) {
		
		List<String> errors = MenageValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Mouvement Stock is not valid {}", dto);
	      throw new InvalidEntityException("La menage n'est pas valide", ErrorCodes.MENAGE_NOT_VALID, errors);
	    }
		return MenageDto.fromEntity(
				menageRepository.save(MenageDto.toEntity(dto))
		);
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenageDto findById(Long id) {
		
		 if (id == null) {
		      log.error("Menage ID is null");
		      return null;
		    }
		return menageRepository.findById(id)
				.map(MenageDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Aucune menage avec l'ID = " +id+ " n' a ete trouve dans la BDD",
						ErrorCodes.MENAGE_NOT_FOUND)
						);
	}

	@Override
	public List<MenageDto> findAll() {
		
		return menageRepository.findAll().stream()
				.map(MenageDto::fromEntity)
				.collect(Collectors.toList());
	}
	
}

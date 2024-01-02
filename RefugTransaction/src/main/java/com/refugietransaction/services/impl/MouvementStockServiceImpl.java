package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.MenageDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.repository.MouvementStockRepository;
import com.refugietransaction.services.MouvementStockService;
import com.refugietransaction.validator.MenageValidator;
import com.refugietransaction.validator.MouvementStockValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MouvementStockServiceImpl implements MouvementStockService {
	
	private MouvementStockRepository mouvementStockRepository;
	
	@Autowired
	public MouvementStockServiceImpl(MouvementStockRepository mouvementStockRepository) {
		this.mouvementStockRepository = mouvementStockRepository;
	}
	
	@Override
	public MouvementStockDto save(MouvementStockDto dto) {
		
		List<String> errors = MouvementStockValidator.validate(dto);
	    if (!errors.isEmpty()) {
	    	
	      throw new InvalidEntityException("Le mouvement stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
	    }
		return MouvementStockDto.fromEntity(
				mouvementStockRepository.save(MouvementStockDto.toEntity(dto))
		);
	}

	@Override
	public MouvementStockDto findById(Long id) {
		
		if (id == null) {
		      log.error("Mouvement stock ID is null");
		      return null;
		    }
		return mouvementStockRepository.findById(id)
				.map(MouvementStockDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Aucun mouvement stock avec l'ID = " +id+ " n' a ete trouve dans la BDD",
						ErrorCodes.MVT_STK_NOT_FOUND)
						);
	}

	@Override
	public List<MouvementStockDto> findAll() {
		
		return mouvementStockRepository.findAll().stream()
				.map(MouvementStockDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		if(id == null) {
			log.error("Mouvement Stock ID is null");
			return;
		}
		
	}

	@Override
	public void update(Long id, MouvementStockDto updatedDto) {
		if (id == null) {
	        log.error("Mouvement stock ID is null");
	        return;
	    }

	    MouvementStockDto existingMvtStockDto = findById(id);

	    if (existingMvtStockDto == null) {
	        throw new EntityNotFoundException("Mouvement stock not found with ID: " + id, ErrorCodes.MVT_STK_NOT_FOUND);
	    }

	    List<String> errors = MouvementStockValidator.validate(updatedDto);
	    if (!errors.isEmpty()) {
	        log.error("Updated mouvement stock is not valid {}", updatedDto);
	        throw new InvalidEntityException("Une menage mis à jour n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
	    }

	    existingMvtStockDto.setDateMouvement(updatedDto.getDateMouvement());
	    existingMvtStockDto.setQuantite(updatedDto.getQuantite());
	    existingMvtStockDto.setTypeMouvement(updatedDto.getTypeMouvement());
	    existingMvtStockDto.setIdArticle(updatedDto.getIdArticle());
	    existingMvtStockDto.setMenage(updatedDto.getMenage());
	    

	    mouvementStockRepository.save(MouvementStockDto.toEntity(existingMvtStockDto));
		
	}

	@Override
	public void stockReelMenage(Long idProduit, Long IdMenage) {
		// TODO Auto-generated method stub
		
	}

}

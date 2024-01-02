package com.refugietransaction.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refugietransaction.dto.MenageDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.dto.ProduitDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.exceptions.InvalidOperationException;
import com.refugietransaction.model.Menage;
import com.refugietransaction.model.MouvementStock;
import com.refugietransaction.repository.MouvementStockRepository;
import com.refugietransaction.repository.ProduitRepository;
import com.refugietransaction.services.ProduitService;
import com.refugietransaction.validator.MenageValidator;
import com.refugietransaction.validator.MouvementStockValidator;
import com.refugietransaction.validator.ProduitValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {
	
	private ProduitRepository produitRepository;
	private MouvementStockRepository mouvementStockRepository;
	
	@Autowired
	public ProduitServiceImpl(ProduitRepository produitRepository, MouvementStockRepository mouvementStockRepository) {
		this.produitRepository = produitRepository;
		this.mouvementStockRepository = mouvementStockRepository;
	}
	
	@Override
	public ProduitDto save(ProduitDto dto) {
		
		List<String> errors = ProduitValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Mouvement Stock is not valid {}", dto);
	      throw new InvalidEntityException("Le produit n'est pas valide", ErrorCodes.PRODUCT_NOT_VALID, errors);
	    }
		return ProduitDto.fromEntity(
				produitRepository.save(ProduitDto.toEntity(dto))
		);
	}

	@Override
	public void update(Long id, ProduitDto updatedDto) {
		if (id == null) {
	        log.error("Produit ID is null");
	        return;
	    }

	    ProduitDto existingProduitDto = findById(id);

	    if (existingProduitDto == null) {
	        throw new EntityNotFoundException("Produit not found with ID: " + id, ErrorCodes.PRODUCT_NOT_FOUND);
	    }

	    List<String> errors = ProduitValidator.validate(updatedDto);
	    if (!errors.isEmpty()) {
	        log.error("Updated produit is not valid {}", updatedDto);
	        throw new InvalidEntityException("Un produit mis à jour n'est pas valide", ErrorCodes.PRODUCT_NOT_VALID, errors);
	    }

	    existingProduitDto.setNomProduit(updatedDto.getNomProduit());
	    

	    produitRepository.save(ProduitDto.toEntity(existingProduitDto));
		
	}

	@Override
	public ProduitDto findById(Long id) {
		
		if (id == null) {
		      log.error("Produit ID is null");
		      return null;
		    }
		return produitRepository.findById(id)
				.map(ProduitDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(
						"Aucun produit avec l'ID = " +id+ " n' a ete trouve dans la BDD",
						ErrorCodes.PRODUCT_NOT_FOUND)
						);
	}

	@Override
	public List<ProduitDto> findAll() {
		
		return produitRepository.findAll().stream()
				.map(ProduitDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		if(id == null) {
			log.error("Produit ID is null");
			return;
		}
		List<MouvementStock> mouvementStocks = mouvementStockRepository.findAllById(id);
		if(!mouvementStocks.isEmpty()) {
			throw new InvalidOperationException("Impossible de supprimer ce produit qui est deja utilisé",
					ErrorCodes.PRODUCT_ALREADY_IN_USE);
		}
		
	}

}

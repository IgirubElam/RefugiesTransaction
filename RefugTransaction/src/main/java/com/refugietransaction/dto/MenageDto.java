package com.refugietransaction.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.refugietransaction.model.Camp;
import com.refugietransaction.model.Menage;
import com.refugietransaction.model.TypeLangue;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenageDto {
	
	private Long id;
	private Long idNumber;
	private String personneContact;
	private String numTelephone;
	private TypeLangue langueParlee;
	private Integer nombrePersonnes;
	
	@JsonIgnore
	private Camp camp;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	@JsonIgnore
	private List<MouvementStockDto> mouvementStocks;
	
	public static MenageDto fromEntity(Menage menage) {
		if(menage == null) {
			return null;
			//TODO throw an exception
		}
		
		return MenageDto.builder()
				.id(menage.getId())
				.idNumber(menage.getIdNumber())
				.personneContact(menage.getPersonneContact())
				.numTelephone(menage.getNumTelephone())
				.langueParlee(menage.getLangueParlee())
				.nombrePersonnes(menage.getNombrePersonnes())
				.camp(menage.getCamp())
				.creationDate(menage.getCreationDate())
				.lastModifiedDate(menage.getLastModifiedDate())
				.build();
	}
	
	public static Menage toEntity(MenageDto menageDto) {
		if(menageDto == null) {
			return null;
			//TODO throw an exception
		}
		
		Menage menage = new Menage();
		menage.setId(menageDto.getId());
		menage.setIdNumber(menageDto.getIdNumber());
		menage.setPersonneContact(menageDto.getPersonneContact());
		menage.setNumTelephone(menageDto.getNumTelephone());
		menage.setLangueParlee(menageDto.getLangueParlee());
		menage.setNombrePersonnes(menageDto.getNombrePersonnes());
		menage.setCamp(menageDto.getCamp());
		menage.setCreationDate(menageDto.getCreationDate());
		menage.setLastModifiedDate(menageDto.getLastModifiedDate());
		
		return menage;
	}
	
}

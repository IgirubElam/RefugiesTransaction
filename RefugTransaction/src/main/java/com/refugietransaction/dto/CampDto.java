package com.refugietransaction.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.refugietransaction.model.Camp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampDto {
	
	private Long id;
	private String nomCamp;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	@JsonIgnore
	private List<MenageDto> menages;
	
	@JsonIgnore
	private List<AgentDto> agents;
	
	public static CampDto fromEntity(Camp camp) {
		if(camp == null){
			return null;
			//TODO throw an exception 
		}
		
		return CampDto.builder()
				.id(camp.getId())
				.nomCamp(camp.getNomCamp())
				.creationDate(camp.getCreationDate())
				.lastModifiedDate(camp.getLastModifiedDate())
				.build();
	}
	
	public static Camp toEntity(CampDto campDto) {
		if(campDto == null){
			return null;
			//TODO throw an exception
		}
		
		Camp camp = new Camp();
		camp.setId(campDto.getId());
		camp.setNomCamp(campDto.getNomCamp());
		camp.setCreationDate(campDto.getCreationDate());
		camp.setLastModifiedDate(campDto.getLastModifiedDate());
		
		return camp;
	}
}

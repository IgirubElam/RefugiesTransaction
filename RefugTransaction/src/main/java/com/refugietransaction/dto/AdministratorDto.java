package com.refugietransaction.dto;

import java.time.Instant;

import com.refugietransaction.model.Administrator;
import com.refugietransaction.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdministratorDto {
	
	private Long id;
	private User user;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	public static AdministratorDto fromEntity(Administrator administrator) {
		if(administrator == null) {
			return null;
			//TODO throw an exception
		}
		
		return AdministratorDto.builder()
				.id(administrator.getId())
				.user(administrator.getUser())
				.creationDate(administrator.getCreationDate())
				.lastModifiedDate(administrator.getLastModifiedDate())
				.build();
	}
	
	public static Administrator toEntity(AdministratorDto administratorDto) {
		if(administratorDto == null) {
			return null;
			//TODO throw an exception
		}
		
		Administrator administrator = new Administrator();
		administrator.setId(administratorDto.getId());
		administrator.setUser(administratorDto.getUser());
		administrator.setCreationDate(administratorDto.getCreationDate());
		administrator.setLastModifiedDate(administratorDto.getLastModifiedDate());
		
		return administrator;
	}
}

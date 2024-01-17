package com.refugietransaction.dto;

import java.time.Instant;

import com.refugietransaction.model.Camp;
import com.refugietransaction.model.User;
import com.refugietransaction.model.UserAssignment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAssignmentDto {
	
	private Long id;
	private User user;
	private Camp camp;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	public static UserAssignmentDto fromEntity(UserAssignment userAssignment) {
		if(userAssignment == null) {
			return null;
		}
		
		return UserAssignmentDto.builder()
				.id(userAssignment.getId())
				.user(userAssignment.getUser())
				.camp(userAssignment.getCamp())
				.creationDate(userAssignment.getCreationDate())
				.lastModifiedDate(userAssignment.getLastModifiedDate())
				.build();
	}
	
	public static UserAssignment toEntity(UserAssignmentDto userAssignmentDto) {
		if(userAssignmentDto == null) {
			return null;
		}
		
		UserAssignment userAssignment = new UserAssignment();
		userAssignment.setId(userAssignmentDto.getId());
		userAssignment.setUser(userAssignmentDto.getUser());
		userAssignment.setCamp(userAssignmentDto.getCamp());
		userAssignment.setCreationDate(userAssignmentDto.getCreationDate());
		userAssignment.setLastModifiedDate(userAssignmentDto.getLastModifiedDate());
		
		return userAssignment;
	}
}

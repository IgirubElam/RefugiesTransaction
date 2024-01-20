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
	private UserDto user;
	private CampDto camp;
	
	public static UserAssignmentDto fromEntity(UserAssignment userAssignment) {
		if(userAssignment == null) {
			return null;
		}
		
		return UserAssignmentDto.builder()
				.id(userAssignment.getId())
				.user(UserDto.fromEntity(userAssignment.getUser()))
				.camp(CampDto.fromEntity(userAssignment.getCamp()))
				.build();
	}
	
	public static UserAssignment toEntity(UserAssignmentDto userAssignmentDto) {
		if(userAssignmentDto == null) {
			return null;
		}
		
		UserAssignment userAssignment = new UserAssignment();
		userAssignment.setId(userAssignmentDto.getId());
		userAssignment.setUser(UserDto.toEntity(userAssignmentDto.getUser()));
		userAssignment.setCamp(CampDto.toEntity(userAssignmentDto.getCamp()));
		
		return userAssignment;
	}
}

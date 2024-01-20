package com.refugietransaction.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.refugietransaction.model.TypeUser;
import com.refugietransaction.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	private Long id;
	private String userFullName;
	private String phoneNumber;
	private String email;
	private String password;
	private TypeUser typeUser;
	private UserAssignmentDto userAssignment;
	
	public static UserDto fromEntity(User user) {
		if(user == null) {
			return null;
			//TODO throw an exception
		}
		
		
		return UserDto.builder()
				.id(user.getId())
				.userFullName(user.getUserFullName())
				.phoneNumber(user.getPhoneNumber())
				.email(user.getEmail())
				.password(user.getPassword())
				.typeUser(user.getTypeUser())
				.userAssignment(UserAssignmentDto.fromEntity(user.getUserAssignment()))
				.build();
	}
	
	public static User toEntity(UserDto userDto) {
		if(userDto == null) {
			return null;
			//TODO throw an exception
		}
		
		User user = new User();
		user.setId(userDto.getId());
		user.setUserFullName(userDto.getUserFullName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setTypeUser(userDto.getTypeUser());
		user.setUserAssignment(UserAssignmentDto.toEntity(userDto.getUserAssignment()));
		
		return user;
	}
}

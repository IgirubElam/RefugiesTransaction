package com.refugietransaction.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.refugietransaction.model.Agent;
import com.refugietransaction.model.Camp;
import com.refugietransaction.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgentDto {
	
	private Long id;
	private User user;
	private Camp camp;
	private Instant creationDate;
	private Instant lastModifiedDate;
	
	@JsonIgnore
	private List<MouvementStockDto> mouvementStocks;
	
	public static AgentDto fromEntity(Agent agent) {
		if(agent == null) {
			return null;
			//TODO throw an exception
		}
		
		return AgentDto.builder()
				.id(agent.getId())
				.user(agent.getUser())
				.camp(agent.getCamp())
				.creationDate(agent.getCreationDate())
				.lastModifiedDate(agent.getLastModifiedDate())
				.build();
	}
	
	public static Agent toEntity(AgentDto agentDto) {
		if(agentDto == null) {
			return null;
			//TODO throw an exception
		}
		
		Agent agent = new Agent();
		agent.setId(agentDto.getId());
		agent.setUser(agentDto.getUser());
		agent.setCamp(agentDto.getCamp());
		agent.setCreationDate(agentDto.getCreationDate());
		agent.setLastModifiedDate(agentDto.getLastModifiedDate());
		
		return agent;
	}
}

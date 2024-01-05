package com.refugietransaction.validator;

import java.util.ArrayList;
import java.util.List;

import com.refugietransaction.dto.AgentDto;

public class AgentValidator {
	
	public static List<String> validate(AgentDto agentDto){
		List<String> errors = new ArrayList<>();
		
		if(agentDto.getCamp() == null || agentDto.getCamp().getId() == null) {
			errors.add("Veillez selectionner le camp");
		}
		
		return errors;
			
	}
}

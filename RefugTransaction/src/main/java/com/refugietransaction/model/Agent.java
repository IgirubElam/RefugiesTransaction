package com.refugietransaction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userI;
}

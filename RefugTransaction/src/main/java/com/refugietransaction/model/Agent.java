package com.refugietransaction.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "camp_id")
	private Camp campId;
	
	@OneToMany(mappedBy = "agentId")
	private List<MouvementStock> mouvementStocks;
}

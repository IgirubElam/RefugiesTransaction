package com.refugietransaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAMP_TBL")
public class Camp {
	
	@Id
	@GeneratedValue
	
	@Column(name = "id_camp")
	private int id_camp;
	
	@Column(name = "nom_camp")
	private String nom_camp;
}
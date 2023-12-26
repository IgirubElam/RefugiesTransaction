package com.refugietransaction.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "menage")
public class Menage {
	
	@Id
	@GeneratedValue
	
	@Column(name = "id_menage")
	private int id_menage;
	
	@Column(name = "id_number")
	private int id_number;
	
	@Column(name = "personne_contact")
	private String personne_contact;
	
	@Column(name = "num_telephone")
	private String num_telephone;
	
	@Column(name = "langue_parlee")
	private String langue_parlee;
	
	@Column(name = "solde")
	private BigDecimal solde;
	
	@ManyToOne
	@JoinColumn(name = "camp_id")
	private Camp camp;
}

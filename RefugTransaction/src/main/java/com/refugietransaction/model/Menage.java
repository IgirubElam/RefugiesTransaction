package com.refugietransaction.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "menage")
public class Menage extends AbstractEntity {
	
	@Column(name = "id_number")
	private Long idNumber;
	
	@Column(name = "personne_contact")
	private String personneContact;
	
	@Column(name = "num_telephone")
	private String numTelephone;
	
	@Column(name = "langue_parlee")
	@Enumerated(EnumType.STRING)
	private TypeLangue langueParlee;
	
	
	@ManyToOne
	@JoinColumn(name = "camp_id")
	private Camp camp;
	
	@OneToMany(mappedBy = "menage")
	private List<MouvementStock> mouvementStocks;
}

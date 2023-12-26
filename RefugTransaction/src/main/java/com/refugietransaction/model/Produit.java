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
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue
	
	@Column(name = "id_produit")
	private int id_produit;
	
	@Column(name = "nom_produit")
	private String nom_produit;
}

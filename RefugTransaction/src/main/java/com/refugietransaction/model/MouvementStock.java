package com.refugietransaction.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mouvement_stock")

public class MouvementStock {
	
	@Id
	@GeneratedValue
	
	@Column(name = "id_mouvement")
	private int idMouvement;
	
	@Column(name = "date_mouvement")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMouvement;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@Column(name = "type_mouvement")
	private String typeMouvement;
	
	@ManyToOne
	@JoinColumn(name = "menage_id")
	private Menage menage;
	
	@ManyToOne 
	@JoinColumn(name = "id_article")
	private Produit idArticle;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}

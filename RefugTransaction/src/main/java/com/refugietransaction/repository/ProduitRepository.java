package com.refugietransaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	// JPQL query
	  @Query(value = "select p from Produit p where p.nom_produit = :nom_produit")
	  Optional<Produit> findProduitByNom(@Param("nom_produit") String nom_produit);
}

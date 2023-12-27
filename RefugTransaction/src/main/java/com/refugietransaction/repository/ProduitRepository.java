package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

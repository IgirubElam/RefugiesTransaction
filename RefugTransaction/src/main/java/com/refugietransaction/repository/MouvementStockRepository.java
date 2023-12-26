package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer> {

}

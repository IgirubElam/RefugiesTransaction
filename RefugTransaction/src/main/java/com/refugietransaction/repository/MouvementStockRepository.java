package com.refugietransaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
	
	@Query("select sum(m.quantite) from  MouvementStock m where m.idArticle.id = :idProduit and m.menage.id = :idMenage")
	BigDecimal stockReelMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);

	List<MouvementStock> findAllById(Long id);

	static List<MouvementStock> findAllByAgentId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

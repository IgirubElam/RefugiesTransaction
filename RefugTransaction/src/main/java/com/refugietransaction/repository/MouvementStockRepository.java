package com.refugietransaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.Menage;
import com.refugietransaction.model.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
	
	@Query("select sum(m.quantite) from  MouvementStock m where m.produit.id = :idProduit and m.menage.id = :idMenage")
	BigDecimal stockReelMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	@Query("select m from  MouvementStock m where m.produit.id = :idProduit and m.menage.id = :idMenage")
	List<MouvementStock> findAllByArticleIdAndMenageId(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	//List<MouvementStock> findAllByArticleIdMenageId(Long id);
	
}

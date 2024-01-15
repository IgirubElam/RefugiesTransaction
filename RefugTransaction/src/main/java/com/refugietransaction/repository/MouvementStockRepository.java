package com.refugietransaction.repository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
	
	@Query("select sum(m.quantite) from  MouvementStock m where m.produit.id = :idProduit and m.menage.id = :idMenage")
	BigDecimal stockReelMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	@Query("select m from  MouvementStock m where m.produit.id = :idProduit and m.menage.id = :idMenage")
	List<MouvementStock> findAllByArticleIdAndMenageId(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	List<MouvementStock> findAllById(Long id);
	
	//Liste des entrees de stock d'un produit donné dans un camp donné
	@Query("select m from MouvementStock m join agent a on m.agent.id = a.id where m.produit.id = :idProduit AND a.camp.id = :idCamp AND m.typeMouvement = 'ENTREE' ")
	List<MouvementStock> findEntreeByIdProduitIdCamp(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp);
	
	//Liste des sorties de stock d'un produit donné dans un camp donné
	@Query("select m from MouvementStock m join agent a on m.agent.id = a.id where m.produit.id = :idProduit AND a.camp.id = :idCamp AND m.typeMouvement = 'SORTIE' ")
	List<MouvementStock> findSortieByIdProduitIdCamp(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp);
	
	//Liste des entrees de stock d'un produit donné dans un camp donné pour une periode donnée
	@Query("select m from MouvementStock m join agent a on m.agent.id = a.id where m.produit.id = :idProduit AND a.camp.id = :idCamp AND m.typeMouvement = 'ENTREE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findEntreeByIdProduitIdCampPeriode(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
	//Liste des sorties de stock d'un produit donné dans un camp donné pour une periode donné
	@Query("select m from MouvementStock m join agent a on m.agent.id = a.id where m.produit.id = :idProduit AND a.camp.id = :idCamp AND m.typeMouvement = 'SORTIE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findSortieByIdProduitIdCampPeriode(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
	//Liste des entrees de stock d'un produit donné dans un menage donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'ENTREE' ")
	List<MouvementStock> findEntreeByIdProduitIdMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	//Liste des sorties de stock d'un produit donné dans un menage donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'SORTIE' ")
	List<MouvementStock> findSortieByIdProduitIdMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	//Liste des entrees de stock d'un produit donné dans un menage donné pour une periode donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'ENTREE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findEntreeByIdProduitIdMenagePeriode(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
	//Liste des sorties de stock d'un produit donné dans un menage donné pour une periode donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'SORTIE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findSortieByIdProduitIdMenagePeriode(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
	//Liste des entrees de stock d'un produit donné effectuées par un agent donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.agent.id = :idAgent AND m.typeMouvement = 'ENTREE' ")
	List<MouvementStock> findEntreeByIdProduitIdAgent(@Param("idProduit") Long idProduit, @Param("idAgent") Long idAgent);
	
	//Liste des sorties de stock d'un produit donné effectuées par un agent donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.agent.id =:idAgent AND m.typeMouvement = 'SORTIE' ")
	List<MouvementStock> findSortieByIdProduitIdAgent(@Param("idProduit") Long idProduit, @Param("idAgent") Long idAgent);
	
	//Liste des entrees de stock d'un produit donné effectuées par un agent donné pour une poriode donnée
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.agent.id = :idAgent AND m.typeMouvement = 'ENTREE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findEntreeByIdProduitIdAgentPeriode(@Param("idProduit") Long idProduit, @Param("idAgent") Long idAgent, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
	//Liste des sorties de stock d'un produit donné effectuées par un agent donné pour une periode donnée
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.agent.id = :idAgent AND m.typeMouvement = 'SORTIE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findSortieByIdProduitIdAgentPeriode(@Param("idProduit") Long idProduit, @Param("idAgent") Long idAgent, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
	
}

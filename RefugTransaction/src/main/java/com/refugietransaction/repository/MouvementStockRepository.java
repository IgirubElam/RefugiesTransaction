package com.refugietransaction.repository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
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
	@Query("select m from MouvementStock m join user u on m.user.id = u.id join UserAssignment ua on u.id = ua.user.id join camp c on ua.camp.id = c.id where m.produit.id = :idProduit AND c.id = :idCamp AND m.typeMouvement = 'ENTREE' ")
	List<MouvementStock> findEntreeByIdProduitIdCamp(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp);
	
	//Liste des sorties de stock d'un produit donné dans un camp donné
	@Query("select m from MouvementStock m join user u on m.user.id = u.id join UserAssignment ua on u.id = ua.user.id join camp c on ua.camp.id = c.id where m.produit.id = :idProduit AND c.id = :idCamp AND m.typeMouvement = 'SORTIE' ")
	List<MouvementStock> findSortieByIdProduitIdCamp(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp);
	
	//Liste des entrees de stock d'un produit donné dans un camp donné pour une periode donnée
	@Query("select m from MouvementStock m join user u on m.user.id = u.id join UserAssignment ua on u.id = ua.user.id join camp c on ua.camp.id = c.id where m.produit.id = :idProduit AND c.id = :idCamp AND m.typeMouvement = 'ENTREE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findEntreeByIdProduitIdCampPeriode(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	//Liste des sorties de stock d'un produit donné dans un camp donné pour une periode donné
	@Query("select m from MouvementStock m join user u on m.user.id = u.id join UserAssignment ua on u.id = ua.user.id join camp c on ua.camp.id = c.id where m.produit.id = :idProduit AND c.id = :idCamp AND m.typeMouvement = 'SORTIE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findSortieByIdProduitIdCampPeriode(@Param("idProduit") Long idProduit, @Param("idCamp") Long idCamp, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	//Liste des entrees de stock d'un produit donné dans un menage donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'ENTREE' ")
	List<MouvementStock> findEntreeByIdProduitIdMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	//Liste des sorties de stock d'un produit donné dans un menage donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'SORTIE' ")
	List<MouvementStock> findSortieByIdProduitIdMenage(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage);
	
	//Liste des entrees de stock d'un produit donné dans un menage donné pour une periode donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'ENTREE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findEntreeByIdProduitIdMenagePeriode(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	//Liste des sorties de stock d'un produit donné dans un menage donné pour une periode donné
	@Query("select m from MouvementStock m where m.produit.id = :idProduit AND m.menage.id = :idMenage AND m.typeMouvement = 'SORTIE' AND m.dateMouvement BETWEEN :startDate AND :endDate ")
	List<MouvementStock> findSortieByIdProduitIdMenagePeriode(@Param("idProduit") Long idProduit, @Param("idMenage") Long idMenage, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	
	
}

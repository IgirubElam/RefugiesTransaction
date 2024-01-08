package com.refugietransaction.controller.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("mouvementStocks")

public interface MouvementStockApi {

    @ApiOperation(value = "Créer un mouvement de stock", notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock",
    		response = MouvementStockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet mouvement de stock n'est pas valide")
    })
    @PostMapping(value = Constants.APP_ROOT + "/mvtstocks/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto save(@RequestBody MouvementStockDto dto);

    @ApiOperation(value = "Trouver un mouvement de stock par son ID", notes = "Cette methode permet de chercher un mouvement de stock par son ID",
    		response = MouvementStockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mouvement de stock a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun mouvement de stock n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = Constants.APP_ROOT + "/mvtstocks/{idMvtStock}", produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto findById(@PathVariable("idMvtStock") Long idMvtStock);

    @ApiOperation(value = "Récupérer la liste de tous les mouvements de stock", notes = "Cette methode permet de chercher et renvoyer la liste des mouvements de stock qui extistent" + "dans la BDD",
    		responseContainer = "List<MouvementStockDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des mouvements de stock / Une liste vide")
    })
    @GetMapping(value = Constants.APP_ROOT + "/mvtstocks/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> findAll();

    @ApiOperation(value = "Supprimer un mouvement de stock par son ID", notes = "Cette methode permet de supprimer un mouvement stock par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mouvement de stock a ete supprime")
    })
    @DeleteMapping(value = Constants.APP_ROOT + "/mvtstocks/delete/{idMvtStock}")
    void delete(@PathVariable("idMvtStock") Long idMvtStock);

    @ApiOperation(value = "Mettre à jour un mouvement de stock par son ID", notes = "Cette methode permet de modifier un mouvement de stock par ID",
    		response = MouvementStockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mouvement de stock a ete mis à jour"),
            @ApiResponse(code = 404, message = "Aucun mouvement de stock n'existe dans la BDD avec l'ID fourni")
    })
    @PutMapping(value = Constants.APP_ROOT + "/mvtstocks/update/{idMvtStock}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable("idMvtStock") Long idMvtStock, @RequestBody MouvementStockDto updatedDto);

    @ApiOperation(value = "Récupérer le stock réel d'un produit dans un ménage", notes = "Cette methode permet de recuperer le stock réel d'un produit dans un ménage", response = MouvementStockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le stock réel a ete trouve"),
            @ApiResponse(code = 404, message = "Aucun mouvement de stock ou produit correspondant n'a ete trouve dans la BDD")
    })
    @GetMapping(value = Constants.APP_ROOT + "/mvtstocks/stockReelMenage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal stockReelMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
}


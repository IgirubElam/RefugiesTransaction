package com.refugietransaction.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.refugietransaction.dto.MenageDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("menages")

public interface MenageApi {

    @ApiOperation("Créer un ménage")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet ménage cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet ménage n'est pas valide")
    })
    @PostMapping(value = Constants.APP_ROOT + "/menages/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MenageDto save(@RequestBody MenageDto dto);

    @ApiOperation("Trouver un ménage par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le ménage a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun ménage n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = Constants.APP_ROOT + "/menages/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    MenageDto findById(@PathVariable("idMenage") Long idMenage);

    @ApiOperation("Récupérer la liste de tous les ménages")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des ménages / Une liste vide")
    })
    @GetMapping(value = Constants.APP_ROOT + "/menages/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MenageDto> findAll();

    @ApiOperation("Trouver l'historique des mouvements de stock d'un produit dans un ménage")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'historique des mouvements de stock a ete trouve"),
            @ApiResponse(code = 404, message = "Aucun ménage ou produit correspondant n'a ete trouve dans la BDD")
    })
    @GetMapping(value = Constants.APP_ROOT + "/menages/historiqueMouvementStock/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> findHistoriqueMouvementStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
}

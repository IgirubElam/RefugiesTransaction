package com.refugietransaction.controller.api;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.dto.MouvementStockDto;
import com.refugietransaction.model.TypeMouvementStock;
import com.refugietransaction.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("mouvementStocks")

public interface MouvementStockApi {

    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/stockReelMenage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal stockReelMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/filter/produit/menage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> mvtStkArticleMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @PostMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree", produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto entreeStock(@RequestBody MouvementStockDto dto);
    
    @PostMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie", produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto sortieStock(@RequestBody MouvementStockDto dto);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/{idProduit}/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleCamp(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/{idProduit}/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleCamp(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/{idProduit}/{idAgent}/{creationDate}/{lastModifiedDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleCampPeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent, @PathVariable("creationDate") Instant creationDate, @PathVariable("lastModifiedDate") Instant lastModifiedDate);
    
}


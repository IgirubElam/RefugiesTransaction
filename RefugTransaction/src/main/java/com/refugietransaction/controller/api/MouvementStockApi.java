package com.refugietransaction.controller.api;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
    
    //Pour le camp
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/camp/{idProduit}/{idCamp}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleCamp(@PathVariable("idProduit") Long idProduit, @PathVariable("idCamp") Long idCamp);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/camp/{idProduit}/{idCamp}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleCamp(@PathVariable("idProduit") Long idProduit, @PathVariable("idCamp") Long idCamp);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/camp/periode/{idProduit}/{idCamp}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleCampPeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idCamp") Long idCamp, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/camp/periode/{idProduit}/{idCamp}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleCampPeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idCamp") Long idCamp, @PathVariable("startDate") Instant startDate, @PathVariable("endDate") Instant endDate);
    
    //Pour le menage
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/menage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/menage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/menage/periode/{idProduit}/{idMenage}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleMenagePeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/menage/periode/{idProduit}/{idMenage}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleMenagePeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage, @PathVariable("startDate") Instant startDate, @PathVariable("endDate") Instant endDate);
    
    //Pour l'agent
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/agent/{idProduit}/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleAgent(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/agent/{idProduit}/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleAgent(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree/produit/agent/periode/{idProduit}/{idAgent}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> entreeArticleAgentPeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent, @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate, @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie/produit/agent/periode/{idProduit}/{idAgent}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> sortieArticleAgentPeriode(@PathVariable("idProduit") Long idProduit, @PathVariable("idAgent") Long idAgent, @PathVariable("startDate") Instant startDate, @PathVariable("endDate") Instant endDate);
    
    
    
}


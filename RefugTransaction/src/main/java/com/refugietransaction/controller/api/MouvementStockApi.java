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

    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/stockReelMenage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal stockReelMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @GetMapping(value = Constants.APP_ROOT + "/mouvementStocks/filter/produit/menage/{idProduit}/{idMenage}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MouvementStockDto> mvtStkArticleMenage(@PathVariable("idProduit") Long idProduit, @PathVariable("idMenage") Long idMenage);
    
    @PostMapping(value = Constants.APP_ROOT + "/mouvementStocks/entree", produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto entreeStock(@RequestBody MouvementStockDto dto);
    
    @PostMapping(value = Constants.APP_ROOT + "/mouvementStocks/sortie", produces = MediaType.APPLICATION_JSON_VALUE)
    MouvementStockDto sortieStock(@RequestBody MouvementStockDto dto);
    
}


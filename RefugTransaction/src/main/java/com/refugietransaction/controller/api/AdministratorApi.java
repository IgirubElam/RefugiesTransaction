package com.refugietransaction.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.refugietransaction.dto.AdministratorDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AdministratorApi {
	
	String APP_ROOT = "/api";

    @ApiOperation("Créer un administrateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet administrateur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet administrateur n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + "/administrators/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministratorDto save(@RequestBody AdministratorDto dto);

    @ApiOperation("Trouver un administrateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'administrateur a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun administrateur n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT + "/administrators/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AdministratorDto findById(@PathVariable("id") Long id);

    @ApiOperation("Récupérer la liste de tous les administrateurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des administrateurs / Une liste vide")
    })
    @GetMapping(value = APP_ROOT + "/administrators/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdministratorDto> findAll();

    @ApiOperation("Supprimer un administrateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'administrateur a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT + "/administrators/delete/{id}")
    void delete(@PathVariable("id") Long id);
}

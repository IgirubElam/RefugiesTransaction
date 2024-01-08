package com.refugietransaction.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.refugietransaction.dto.AgentDto;
import com.refugietransaction.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("agents")
public interface AgentApi {

    @ApiOperation(value = "Créer un agent", notes = "Cette methode permet d'enregistrer ou modifier un agent", response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet agent cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet agent n'est pas valide")
    })
    @PostMapping(value = Constants.APP_ROOT + "/agents/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AgentDto save(@RequestBody AgentDto dto);

    @ApiOperation(value = "Trouver un agent par son ID", notes = "Cette methode permet de chercher un agent par son ID", response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun agent n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = Constants.APP_ROOT + "/agents/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    AgentDto findById(@PathVariable("idAgent") Long idAgent);

    @ApiOperation(value = "Récupérer la liste de tous les agents", notes = "Cette methode permet de chercher et renvoyer la liste des agents qui existent" + "dans la BDD", 
    		responseContainer = "List<AgentDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des agents / Une liste vide")
    })
    @GetMapping(value = Constants.APP_ROOT + "/agents/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AgentDto> findAll();

    @ApiOperation(value = "Supprimer un agent par son ID", notes = "Cette methode permet de supprimer un agent par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete supprime")
    })
    @DeleteMapping(value = Constants.APP_ROOT + "/agents/delete/{idAgent}")
    void delete(@PathVariable("idAgent") Long idAgent);

    @ApiOperation(value = "Mettre à jour un agent par son ID", notes = "Cette methode permet de mettre à jour un agent", response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete mis à jour"),
            @ApiResponse(code = 404, message = "Aucun agent n'existe dans la BDD avec l'ID fourni")
    })
    @PutMapping(value = Constants.APP_ROOT + "/agents/update/{idAgent}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable("idAgent") Long idAgent, @RequestBody AgentDto updatedDto);

    @ApiOperation(value = "Trouver tous les agents liés à un utilisateur par son ID", notes = "Cette methode permet de lister tous les agents liés à un utilisateur par son ID",
    		responseContainer = "List<AgentDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des agents liés à l'utilisateur / Une liste vide")
    })
    @GetMapping(value = Constants.APP_ROOT + "/agents/findByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AgentDto> findAllByUserId(@PathVariable("userId") Long userId);
}

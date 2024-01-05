package com.refugietransaction.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.refugietransaction.dto.AgentDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.refugietransaction.utils.Contants.APP_ROOT;

@Api("agents")

public interface AgentApi {

    @ApiOperation("Créer un agent")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet agent cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet agent n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + "/agents/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AgentDto save(@RequestBody AgentDto dto);

    @ApiOperation("Trouver un agent par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun agent n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT + "/agents/{idAgent}", produces = MediaType.APPLICATION_JSON_VALUE)
    AgentDto findById(@PathVariable("idAgent") Long idAgent);

    @ApiOperation("Récupérer la liste de tous les agents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des agents / Une liste vide")
    })
    @GetMapping(value = APP_ROOT + "/agents/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AgentDto> findAll();

    @ApiOperation("Supprimer un agent par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT + "/agents/delete/{idAgent}")
    void delete(@PathVariable("idAgent") Long idAgent);

    @ApiOperation("Mettre à jour un agent par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'agent a ete mis à jour"),
            @ApiResponse(code = 404, message = "Aucun agent n'existe dans la BDD avec l'ID fourni")
    })
    @PutMapping(value = APP_ROOT + "/agents/update/{idAgent}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable("idAgent") Long idAgent, @RequestBody AgentDto updatedDto);

    @ApiOperation("Trouver tous les agents liés à un utilisateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des agents liés à l'utilisateur / Une liste vide")
    })
    @GetMapping(value = APP_ROOT + "/agents/findByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AgentDto> findAllByUserId(@PathVariable("userId") Long userId);
}

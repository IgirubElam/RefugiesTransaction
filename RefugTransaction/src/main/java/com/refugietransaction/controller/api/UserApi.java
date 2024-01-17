package com.refugietransaction.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.refugietransaction.dto.UserAssignmentDto;
import com.refugietransaction.dto.UserDto;
import com.refugietransaction.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api("utilisateurs")
public interface UserApi {
	
	@ApiOperation(value = "Enregistrer un utilisateur", notes = "Cette methode permet d'enregistrer ou modifier un utilisateur", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet utilisateur créer / modifier"),
			@ApiResponse(code = 400, message = "L'utilisateur n'est pas valide")
	})
	@PostMapping(value = Constants.APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UserDto save(@RequestBody UserDto dto, UserAssignmentDto userAssignmentDto);
	
	@ApiOperation(value = "Rechercher un utilisateur", notes = "Cette methode permet de chercher un utilisateur par ID", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet utilisateur a été trouvé"),
			@ApiResponse(code = 400, message = "L'utilisateur n'a pas été trouvé")
	})
	@GetMapping(value = Constants.APP_ROOT + "/utilisateurs/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
	UserDto findById(@PathVariable("idUser") Long idUser);
	
	@ApiOperation(value = "Rechercher un utilisateur par email", notes = "Cette methode permet de chercher un utilisateur par email", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet utilisateur a été trouvé"),
			@ApiResponse(code = 400, message = "L'utilisateur n'a pas été trouvé")
	})
	@GetMapping(value = Constants.APP_ROOT + "/utilisateurs/{Email}", produces = MediaType.APPLICATION_JSON_VALUE)
	UserDto findByEmail(@PathVariable("email") String email);
	
	@ApiOperation(value = "Rechercher la liste des utilisateurs", notes = "Cette methode permet de chercher et envoyer la liste des utilisateurs", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La liste des utilisateurs / une liste vide"),
	})
	@GetMapping(value = Constants.APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<UserDto> findAll();
	
	@ApiOperation(value = "Supprimer un utilisateur", notes = "Cette methode permet de supprimer un utilisateur par ID", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet utilisateur a été supprimé"),
	})
	@GetMapping(value = Constants.APP_ROOT + "/utilisateurs/delete/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(@PathVariable("idUser") Long id);
	
	
}

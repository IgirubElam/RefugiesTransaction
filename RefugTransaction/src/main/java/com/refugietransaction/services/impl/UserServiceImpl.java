package com.refugietransaction.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.refugietransaction.dto.ChangerUserPasswordDto;
import com.refugietransaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.refugietransaction.dto.UserDto;
import com.refugietransaction.exceptions.EntityNotFoundException;
import com.refugietransaction.exceptions.ErrorCodes;
import com.refugietransaction.exceptions.InvalidEntityException;
import com.refugietransaction.exceptions.InvalidOperationException;
import com.refugietransaction.repository.UserRepository;
import com.refugietransaction.services.UserService;
import com.refugietransaction.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDto save(UserDto userDto) {

		List<String> errors = UserValidator.validate(userDto);

		if (!errors.isEmpty()) {
			log.error("Utilisateur is not valid {}", userDto);
			throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
		}

		if(userAlreadyExists(userDto.getEmail())) {
			throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
					Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
		}

		return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));
	}

	private boolean userAlreadyExists(String email) {
		Optional<User> user = userRepository.findUserByEmail(email);
		return user.isPresent();
	}

	@Override
	public UserDto findById(Long id) {
		
		if (id == null) {
		      log.error("User ID is null");
		      return null;
		    }
		
		Optional<User> user = userRepository.findById(id);
		
		return Optional.of(UserDto.fromEntity(user.get())).orElseThrow(()->
				new EntityNotFoundException("Aucun utilisateur avec l'ID = " + id + "n'a été trouvé dans la BDD",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
		
//		return userRepository.findById(id)
//				.map(UserDto::fromEntity)
//				.orElseThrow(()->new EntityNotFoundException(
//						"Aucun utilisateur avec l'ID = " +id+ " n' a ete trouve dans la BDD",
//						ErrorCodes.UTILISATEUR_NOT_FOUND)
//						);
	}

	@Override
	public List<UserDto> findAll() {
		
		return userRepository.findAll().stream()
				.map(UserDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		if(id == null) {
			log.error("User ID is null");
			return;
		}
		
		userRepository.deleteById(id);
		
	}

	@Override
	public UserDto findByEmail(String email) {
		return userRepository.findUserByEmail(email)
				.map(UserDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun utilisateur avec le mail = " + email + "n'a été trouvé dans la BDD",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UserDto changerMotDePasse(ChangerUserPasswordDto dto) {
		
		validate(dto);
		Optional<User> userOptional = userRepository.findById(dto.getId());
		if(userOptional.isEmpty()) {
			log.warn("Aucun utilisateur n a été trouvé avec l'ID" + dto.getId());
			throw new EntityNotFoundException("Aucun utilisateur n a été trouvé avec l'ID" + dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
		}
		
		User user = userOptional.get();
		user.setPassword(dto.getMotDePasse());
		return UserDto.fromEntity(
				userRepository.save(user)
		);
	}
	
	private void validate(ChangerUserPasswordDto dto) {
		if(dto == null) {
			log.warn("Impossible de modifier le mot de passe avec un objet null");
			throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		if(dto.getId() == null) {	
			log.warn("Impossible de modifier le mot de passe avec un objet null");
			throw new InvalidOperationException("ID utilisateur null impossible de modifier le mot de passe", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		if(!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
			log.warn("Impossible de modifier le mot de passe avec un mot de passe vide");
			throw new InvalidOperationException("Mot de passe utilisateur vide impossible de modifier", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		
		if(!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
			log.warn("Impossible de modifier le mot de passe avec un deux mot de passe different null");
			throw new InvalidOperationException("Mots de passe utilisateur different, impossible de modifier le mot de passe", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
	}



}

//package com.refugietransaction.services.impl;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import com.refugietransaction.dto.AdministratorDto;
//import com.refugietransaction.dto.AgentDto;
//import com.refugietransaction.dto.ChangerUserPasswordDto;
//import com.refugietransaction.model.Agent;
//import com.refugietransaction.model.User;
//import com.refugietransaction.validator.AgentValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.refugietransaction.dto.UserDto;
//import com.refugietransaction.exceptions.EntityNotFoundException;
//import com.refugietransaction.exceptions.ErrorCodes;
//import com.refugietransaction.exceptions.InvalidEntityException;
//import com.refugietransaction.exceptions.InvalidOperationException;
//import com.refugietransaction.model.Administrator;
//import com.refugietransaction.repository.AdministratorRepository;
//import com.refugietransaction.repository.AgentRepository;
//import com.refugietransaction.repository.UserRepository;
//import com.refugietransaction.services.UserService;
//import com.refugietransaction.validator.UserValidator;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class UserServiceImpl implements UserService {
//	
//	private final UserRepository userRepository;
//	private final AdministratorRepository administratorRepository;
//	private final AgentRepository agentRepository;
//	
//	@Autowired
//	public UserServiceImpl(UserRepository userRepository, AdministratorRepository administratorRepository, AgentRepository agentRepository) {
//		this.userRepository = userRepository;
//		this.administratorRepository = administratorRepository;
//		this.agentRepository = agentRepository;
//	}
//	
//	@Override
//	public UserDto save(UserDto userDto, AdministratorDto administratorDto, AgentDto agentDto) {
//
//		List<String> errors = UserValidator.validate(userDto);
//		List<String> errors_agent = AgentValidator.validate(agentDto);
//
//		if (!errors.isEmpty()) {
//			log.error("Utilisateur is not valid {}", userDto);
//			throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
//		}
//
//		if(userAlreadyExists(userDto.getEmail())) {
//			throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
//					Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
//		}
//
//		if (userDto.getTypeUser().name().equals("AGENT")){
//
//			if (!errors_agent.isEmpty()){
//				log.error("Agent is not valid {}", userDto);
//				throw new InvalidEntityException("L'agent n'est pas valide", ErrorCodes.AGENT_NOT_VALID, errors_agent);
//			}
//
//			User SavedAgentUser = userRepository.save(UserDto.toEntity(userDto));
//			if (userDto.getAgents()!= null) {
//				Agent agent = AgentDto.toEntity(agentDto);
//				agent.setUser(SavedAgentUser);
//				agentRepository.save(agent);
//			}
//
//		}
//		else{
//
//			User SavedAdminUser = userRepository.save(UserDto.toEntity(userDto));
//			if (userDto.getAdministrators()!= null) {
//				Administrator administrator = AdministratorDto.toEntity(administratorDto);
//				administrator.setUser(SavedAdminUser);
//				administratorRepository.save(administrator);
//			}
//
//		}
//
//		return UserDto.fromEntity(UserDto.toEntity(userDto));
//	}
//
//	private boolean userAlreadyExists(String email) {
//		Optional<User> user = userRepository.findUserByEmail(email);
//		return user.isPresent();
//	}
//
//	@Override
//	public UserDto findById(Long id) {
//		
//		if (id == null) {
//		      log.error("User ID is null");
//		      return null;
//		    }
//		return userRepository.findById(id)
//				.map(UserDto::fromEntity)
//				.orElseThrow(()->new EntityNotFoundException(
//						"Aucun utilisateur avec l'ID = " +id+ " n' a ete trouve dans la BDD",
//						ErrorCodes.UTILISATEUR_NOT_FOUND)
//						);
//	}
//
//	@Override
//	public List<UserDto> findAll() {
//		
//		return userRepository.findAll().stream()
//				.map(UserDto::fromEntity)
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public void delete(Long id) {
//		
//		if(id == null) {
//			log.error("User ID is null");
//			return;
//		}
//
//		User user=userRepository.findUserById(id);
//		if (user.getTypeUser().name().equals("ADMINISTRATOR")){
//           userRepository.deleteById(id);
//           for (Administrator admin : user.getAdministrators()) {
//               administratorRepository.delete(admin);
//           }
//		}
//		else{
//
//		}
//
//		List<Administrator> administrators = administratorRepository.findAllById(id);
//		List<Agent> agents = agentRepository.findAllById(id);
//		if(!administrators.isEmpty() || !agents.isEmpty()) {
//			throw new InvalidOperationException("Impossible de supprimer cet utilisateur qui est deja utilisé",
//					ErrorCodes.UTILISATEUR_ALREADY_EXISTS);
//		}
//		
//	}
//
//	@Override
//	public UserDto findByEmail(String email) {
//		return null;
//	}
//
//	@Override
//	public UserDto changerMotDePasse(ChangerUserPasswordDto dto) {
//		return null;
//	}
//
//
//
//}

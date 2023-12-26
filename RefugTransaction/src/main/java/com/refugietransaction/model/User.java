package com.refugietransaction.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity {
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private TypeUser typeUser;
	
	@OneToMany(mappedBy = "user")
	private List<MouvementStock> mouvementStocks;
	
	@OneToMany(mappedBy = "userId")
	private List<Administrator> administrators;
	
	@OneToMany(mappedBy = "userI")
	private List<Agent> agents;
}

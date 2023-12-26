package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

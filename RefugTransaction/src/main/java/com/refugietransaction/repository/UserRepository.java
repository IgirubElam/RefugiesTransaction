package com.refugietransaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.refugietransaction.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllById(Long id);
	// JPQL query
    @Query(value = "select u from User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query(value = "select u from User u where u.id = :id")
    User findUserById(@Param("id") Long id);
    
}

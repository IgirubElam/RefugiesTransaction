package com.refugietransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refugietransaction.model.UserAssignment;

public interface UserAssignmentRepository extends JpaRepository<UserAssignment, Long> {

}

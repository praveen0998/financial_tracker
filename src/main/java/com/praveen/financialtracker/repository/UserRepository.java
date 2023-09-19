package com.praveen.financialtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.financialtracker.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

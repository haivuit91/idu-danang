package com.idu.judi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idu.judi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
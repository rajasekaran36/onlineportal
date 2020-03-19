package com.kgisl.raja.onlineportal.repository;

import com.kgisl.raja.onlineportal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
 
}
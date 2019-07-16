package com.amal.rajeeda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.rajeeda.model.User;

public interface LoginRepo extends JpaRepository<User, Integer> {

	
}

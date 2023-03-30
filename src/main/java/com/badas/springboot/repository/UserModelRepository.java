package com.badas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badas.springboot.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long>{
	
	UserModel findByEmail(String emailId);

}

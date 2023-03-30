package com.badas.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.badas.springboot.DTO.UserRegisteredDTO;
import com.badas.springboot.model.UserModel;

public interface DefaultUserService extends UserDetailsService {
	
	UserModel save(UserRegisteredDTO userRegisteredDTO);

}

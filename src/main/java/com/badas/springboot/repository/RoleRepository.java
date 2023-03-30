package com.badas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badas.springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String name);

}

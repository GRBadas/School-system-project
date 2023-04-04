package com.badas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badas.springboot.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}

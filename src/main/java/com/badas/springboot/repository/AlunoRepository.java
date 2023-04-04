package com.badas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badas.springboot.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}

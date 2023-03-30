package com.badas.springboot.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Aluno {
	
	@javax.persistence.Id
	private UUID Id;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private Integer idade;

}

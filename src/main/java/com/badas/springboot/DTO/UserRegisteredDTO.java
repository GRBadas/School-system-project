package com.badas.springboot.DTO;

import lombok.Data;

@Data
public class UserRegisteredDTO {
	
	private String name;
	
	private String password;
	
	private String email_id;
	
	private String role;

}

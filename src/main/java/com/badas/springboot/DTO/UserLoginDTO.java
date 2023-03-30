package com.badas.springboot.DTO;

import lombok.Data;

@Data
public class UserLoginDTO {
	
	private String Username;
	
	private long otp;

}

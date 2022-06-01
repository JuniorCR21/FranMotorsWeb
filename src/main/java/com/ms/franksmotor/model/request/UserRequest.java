package com.ms.franksmotor.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRequest {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String role;
}

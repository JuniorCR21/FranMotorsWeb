package com.ms.franksmotor.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeRequest {

	private String name;
	
	private String surname;
	
	private String dni;
	
	private String email;
	
	private String phone;
	
	private String dateBirth;
	
	private String password;
	
	private String role;
	
}

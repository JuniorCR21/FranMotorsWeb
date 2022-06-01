package com.ms.franksmotor.model.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeResponse {
	
	private int id;
	
	private int idUser;

	private String name;
	
	private String surname;
	
	private String dni;
	
	private String email;
	
	private String phone;
	
	private LocalDateTime dateBirth;
	
	private String username;
	
	private Boolean status;
	
	private String role;
	
	private Boolean accountLocked;
}

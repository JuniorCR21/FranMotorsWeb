package com.ms.franksmotor.model.db;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "dni", length = 8, unique = true)
	private String dni;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "date_birth")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDateTime dateBirth;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}

package com.ms.franksmotor.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Motorbike")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Motorbike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "number_plate")
	private String numberPlate;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "serial_number")
	private String serialNumber;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "year")
	private int year;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	@JsonIgnore
	private Client client;
}

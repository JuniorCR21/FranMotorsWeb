package com.ms.franksmotor.model.response;

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
public class MotorbikeResponse {

	private int id;
	
	private String numberPlate;
	
	private String brand;
	
	private String serialNumber;
	
	private String status;
	
	private int year;
	
}

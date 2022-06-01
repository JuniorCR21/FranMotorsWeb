package com.ms.franksmotor.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MotorbikeRequest {

	private String numberPlate;
	
	private String brand;
	
	private String serialNumber;
	
	private String status;
	
	private int year;
	
	private int clientId;
}
